package day2;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MainDay2 {

	public static TreeMap<Integer, ArrayList<SetOfCubes>> mapGames;
	
	public static boolean isDebug = false;
	
	public static void convertInputInGames() throws Exception {
		// Séparation de l'entrée en lignes
        String[] lines;
        if(isDebug) {
        	lines = InputDay2.INPUT_DAY2_TEST.split("\r\n");
        } else {
        	lines = InputDay2.INPUT_DAY2.split("\r\n");
        }
        	
        //Création de la map et remplissage
        mapGames = new TreeMap<Integer, ArrayList<SetOfCubes>>();
        ArrayList<SetOfCubes> listSetOfCubes;
        Scanner scannerGames;
        Scanner scannerSetOfCubes;
        
        int quantityCubeScanner;
        String colorCubeScanner;
        
        for(int indexLine = 0; indexLine < lines.length; indexLine++) {
        	listSetOfCubes = new ArrayList<SetOfCubes>();
        	
        	scannerGames = new Scanner(lines[indexLine]);	

        	while (scannerGames.hasNextLine()) {
        		String ligneGames = scannerGames.nextLine();
	
        		// Séparation de la ligne entre le numéro de la game et la liste des sets
        		String[] elementsGameAndSets = ligneGames.split(": ");
        		// Séparation de la ligne entre les différents sets
        		String[] elementsSets = elementsGameAndSets[1].split("; ");
        		//Séparation de chaque sets en paires quantité|couleur
        		String[] elementsCubes;
        		
        		//Traitement des données
        		if((indexLine + 1) != Integer.parseInt(elementsGameAndSets[0].substring(5))) {
        			scannerGames.close();
        			throw new Exception("L'index des games est incorrect pour l'index+1 " + (indexLine + 1) + " vs element " + elementsGameAndSets[0].substring(5));
        		}

        		for(int indexSet = 0; indexSet < elementsSets.length; indexSet++) {
        			//1 blue, 2 green ==> {1 blue} {2 green}
        			elementsCubes = elementsSets[indexSet].split(", ");
        			
        			SetOfCubes setCubesToAdd = new SetOfCubes();
        			
        			for(int indexCubes = 0; indexCubes < elementsCubes.length; indexCubes++) {
        				scannerSetOfCubes = new Scanner(elementsCubes[indexCubes]);
        				
        				quantityCubeScanner = scannerSetOfCubes.nextInt();
        				colorCubeScanner = scannerSetOfCubes.next();
        				switch(colorCubeScanner) {
        					case "green":
        						setCubesToAdd.setNbGreenCubes(quantityCubeScanner);
        						break;
        					case "blue":
        						setCubesToAdd.setNbBlueCubes(quantityCubeScanner);
        						break;
        					case "red":
        						setCubesToAdd.setNbRedCubes(quantityCubeScanner);
        						break;
    						default :
    							scannerSetOfCubes.close();
    							throw new Exception("Le scanner pour séparer la paire quantité|couleur : '" + quantityCubeScanner + "'|'" + colorCubeScanner + "'");
        				}
        				
        				scannerSetOfCubes.close();
        			}
        			
        			listSetOfCubes.add(setCubesToAdd);
        		}
	        }
	
	        scannerGames.close();
	         
	        mapGames.put(indexLine + 1, listSetOfCubes);
        }
	}
	
	/**
	 * V1 calcule le nombre de games possibles en se basant sur les limites imposées dans l'énoncé
	 * @return
	 */
	public static int calcGamesPossible() {
		int nbGamesPossible = 0;
		
		boolean allSetsPossible;
		for (Map.Entry<Integer, ArrayList<SetOfCubes>> entryGame: mapGames.entrySet()) {
			allSetsPossible = true;
			
            for(SetOfCubes setOfCube : entryGame.getValue()) {
            	if(!setOfCube.isSetOfCubesPossible(InputDay2.LIMITS[0], InputDay2.LIMITS[1], InputDay2.LIMITS[2])) {
            		allSetsPossible = false;
            		break;
            	}
            }
            
            if(allSetsPossible) {
            	nbGamesPossible += entryGame.getKey();         
            	System.out.println("calcGamesPossible ajout d'un game possible : n°" + entryGame.getKey() + " et score actuel : " + nbGamesPossible);
            }
        }
		
		return nbGamesPossible;
	}
	
	/**
	 * V2
	 * @return
	 */
	public static int calcMinimumSetOfCubesPower() {
		int powerTotal = 0;
		
		int powerMin;
		
		//Minimum de cubes par game
		int minBlueCubes;
		int minRedCubes;
		int minGreenCubes;
		
		//parcourir chaque games
		for (Map.Entry<Integer, ArrayList<SetOfCubes>> entryGame: mapGames.entrySet()) {
			minBlueCubes = 0;
			minRedCubes = 0;
			minGreenCubes = 0;
			
			for(SetOfCubes setOfCube : entryGame.getValue()) {
				//en parcourant chaque set, déterminer le minimum de cubes de chaque couleur
				if(setOfCube.getNbBlueCubes() != 0 && setOfCube.getNbBlueCubes() > minBlueCubes)
					minBlueCubes = setOfCube.getNbBlueCubes();
			
				if(setOfCube.getNbRedCubes() != 0 && setOfCube.getNbRedCubes() > minRedCubes)
					minRedCubes = setOfCube.getNbRedCubes();
				
				if(setOfCube.getNbGreenCubes() != 0 && setOfCube.getNbGreenCubes() > minGreenCubes)
					minGreenCubes = setOfCube.getNbGreenCubes();
			}
			
			System.out.println("calcMinimumSetOfCubesPower game n°" + entryGame.getKey() + "; RGB = ("+ minRedCubes + "-" + minGreenCubes + "-" + minBlueCubes +")");
			
			//Dans le cas où une game n'a pas besoin d'une couleur de cube, il faut passer la valeur à 0 pour ce set
			//ce qui revient à un power total de 0
			if(minBlueCubes == 0 || minRedCubes == 0 || minGreenCubes == 0) {
				System.out.println("calcMinimumSetOfCubesPower() ; la game n°" + entryGame.getKey() + " dispose d'une couleur inexistante" );
			} else {
				//calculer le pouvoir de chaque set de cubes minimum
				powerMin = SetOfCubes.calcSetOfCubesPower(minBlueCubes, minRedCubes, minGreenCubes);
				
				powerTotal += powerMin;
				
            	System.out.println("calcMinimumSetOfCubesPower ajout du power de " + powerMin + " : n°" + entryGame.getKey() + " et score actuel : " + powerTotal);

			}
			
        }
					
		return powerTotal;
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		convertInputInGames();
		
		
		//2379 trop haut
		int resultV1 = calcGamesPossible();
		System.out.println("Result V1 : " + resultV1);
		
		int resultV2 = calcMinimumSetOfCubesPower();
		System.out.println("Result V2 : " + resultV2);
	}

}
