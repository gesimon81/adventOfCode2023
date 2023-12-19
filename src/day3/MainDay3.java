package day3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class MainDay3 {
	
	public static boolean isDebug = false;

	/**
	 * Représentation du quadrillage
	 */
	public static HashMap<Coordinate, SchematicElementUnit> schematicByUnits;
	
	//Faciliter l'identification des éléments à tester autour de chaque symbole
	public static HashMap<Integer, ArrayList<SchematicElementGroup>> schematicByGroupsPerLine;
	
	//Positions des symboles pour comparer leur alentours
	public static HashMap<Coordinate, SchematicElementUnit> symbolsPositions;
	
	//Position de chaqué élement
	
	
	/**
	 * Créer un quadrillage avec toutes les coordonnées 
	 * @throws Exception
	 */
	public static void convertInput() throws Exception {
		// Séparation de l'entrée en lignes
        String[] lines;
        if(isDebug) {
        	lines = InputDay3.INPUT_DAY3_TEST.split("\r\n");
        } else {
        	lines = InputDay3.INPUT_DAY3.split("\r\n");
        }
        
        
        //Création de la map et remplissage
        schematicByUnits = new HashMap<Coordinate, SchematicElementUnit>();
        schematicByGroupsPerLine = new HashMap<Integer, ArrayList<SchematicElementGroup>>();
        symbolsPositions = new HashMap<Coordinate, SchematicElementUnit>();
        
        
        //Parcours de chaque lignes. Pour chaque élément, on l'ajoute au quadrillage; ensuite :
        //Si c'est un nombre, on l'ajoute à un groupe
        //Si c'est un symbole, on l'enregistre dans la map des symboles
        //Si c'est un '.', pas de traitement supplémentaire
        
        //Element parcouru actuellement
        String elementRead;
        SchematicElementUnit elementToCreate;
        SchematicElementGroup groupToCreate = null;
        
        for(int indexLine = 0; indexLine < lines.length; indexLine++) {
        	schematicByGroupsPerLine.put(indexLine, new ArrayList<SchematicElementGroup>());
        	
        	for(int indexColumn = 0; indexColumn < lines[0].length(); indexColumn++) {
        		elementRead = lines[indexLine].substring(indexColumn, indexColumn + 1);
        	
        		elementToCreate = new SchematicElementUnit(SchematicElementType.determineTypeOfElement(elementRead), new Coordinate(indexLine, indexColumn), elementRead);
        		schematicByUnits.put(elementToCreate.getCoordinate(), elementToCreate);
        		
        		switch(elementToCreate.getType()) {
        			case SchematicElementType.NUMBER:
        				if(groupToCreate == null) {
        					groupToCreate = new SchematicElementGroup();
        				}
        				groupToCreate.addNumberElement(elementToCreate);
        				break;
        			case SchematicElementType.SYMBOL:
        				symbolsPositions.put(elementToCreate.getCoordinate(), elementToCreate);
        				
        				//Fermer le nombre précédent s'il existe
        				if(groupToCreate != null) {
        					schematicByGroupsPerLine.get(indexLine).add(groupToCreate);
        					groupToCreate = null;
        				}
        				break;
        			case SchematicElementType.DOT:
        				//Fermer le nombre précédent s'il existe
        				if(groupToCreate != null) {
        					schematicByGroupsPerLine.get(indexLine).add(groupToCreate);
        					groupToCreate = null;
        				}
        				break;
        		}
        	}
        	
        	if(groupToCreate != null) {
				schematicByGroupsPerLine.get(indexLine).add(groupToCreate);
				groupToCreate = null;
			}
        }
	}
	
	public static int calcPartNumbers() {
		int resultTotal = 0;
		
		//Créer une copie de la map schematicByGroupsPerLine où les groupes déjà explorés seront supprimés pour éviter d'être lu plusieurs fois
		HashMap<Integer, ArrayList<SchematicElementGroup>> schematicByGroupsPerLineCopy = schematicByGroupsPerLine;
		
		ArrayList<SchematicElementGroup> listGroupsToReplace;
		
		//Parcourir chaque symbole et identifier les nombres adjacents
		for (Map.Entry<Coordinate, SchematicElementUnit> entrySymbol: symbolsPositions.entrySet()) {
			//Tester les 8 positions autour du symbol et si on trouve un nombre, alors l'ajouter au total puis l'effacer de la map
			
			//Tester sur la même ligne
			if(schematicByGroupsPerLineCopy.containsKey(entrySymbol.getKey().getCoordX()) && !schematicByGroupsPerLineCopy.get(entrySymbol.getKey().getCoordX()).isEmpty()) {
				//Pour effacer les nombres déjà lus sans causer de conflits avec le parcours, on crée une liste vide qui sera remplie par les chiffres non adjacents, et ensuite remplacer la liste de la ligne
				listGroupsToReplace = new ArrayList<SchematicElementGroup>();
				
				for(SchematicElementGroup entryGroup : schematicByGroupsPerLineCopy.get(entrySymbol.getKey().getCoordX())) {
					if(entryGroup.isAdjacentToUnit(entrySymbol.getKey())) {
						//Ajouter le nombre au total
						resultTotal += Integer.parseInt(entryGroup.getValue());
					} else {
						listGroupsToReplace.add(entryGroup);
					}
				}
				
				schematicByGroupsPerLineCopy.put(entrySymbol.getKey().getCoordX(), listGroupsToReplace);
			}
			
			//Tester la ligne du dessus
			if(schematicByGroupsPerLineCopy.containsKey(entrySymbol.getKey().getCoordX() + 1) && !schematicByGroupsPerLineCopy.get(entrySymbol.getKey().getCoordX() + 1).isEmpty()) {
				//Pour effacer les nombres déjà lus sans causer de conflits avec le parcours, on crée une liste vide qui sera remplie par les chiffres non adjacents, et ensuite remplacer la liste de la ligne
				listGroupsToReplace = new ArrayList<SchematicElementGroup>();
				
				for(SchematicElementGroup entryGroup : schematicByGroupsPerLineCopy.get(entrySymbol.getKey().getCoordX() + 1)) {
					if(entryGroup.isAdjacentToUnit(entrySymbol.getKey())) {
						//Ajouter le nombre au total
						resultTotal += Integer.parseInt(entryGroup.getValue());
					} else {
						listGroupsToReplace.add(entryGroup);
					}
				}
				
				schematicByGroupsPerLineCopy.put(entrySymbol.getKey().getCoordX() + 1, listGroupsToReplace);
			}
			
			//Tester la ligne d'en dessous
			if(schematicByGroupsPerLineCopy.containsKey(entrySymbol.getKey().getCoordX() - 1) && !schematicByGroupsPerLineCopy.get(entrySymbol.getKey().getCoordX() - 1).isEmpty()) {
				//Pour effacer les nombres déjà lus sans causer de conflits avec le parcours, on crée une liste vide qui sera remplie par les chiffres non adjacents, et ensuite remplacer la liste de la ligne
				listGroupsToReplace = new ArrayList<SchematicElementGroup>();
				
				for(SchematicElementGroup entryGroup : schematicByGroupsPerLineCopy.get(entrySymbol.getKey().getCoordX() - 1)) {
					if(entryGroup.isAdjacentToUnit(entrySymbol.getKey())) {
						//Ajouter le nombre au total
						resultTotal += Integer.parseInt(entryGroup.getValue());
					} else {
						listGroupsToReplace.add(entryGroup);
					}
				}
				
				schematicByGroupsPerLineCopy.put(entrySymbol.getKey().getCoordX() - 1, listGroupsToReplace);
			}
		}
		
		return resultTotal;
	}

	public static int calcGearsNumbers() {
		int resultTotal = 0;
		
		//Identifier les éléments adjacents pour chaque gear potentiel, et si la taille = 2, alors gear
		ArrayList<SchematicElementGroup> listGroupsAdjacentToAGearSymbol;
		
		//Parcourir chaque symbole et identifier les gears puis identifier les nombres adjacents
		for (Map.Entry<Coordinate, SchematicElementUnit> entrySymbol: symbolsPositions.entrySet()) {
			//Si le symbole = '*', alors c'est un potentiellement un gear. Sinon on passe au suivant
			if(entrySymbol.getValue().isAGearSymbol()) {
				System.out.println("calcGearsNumbers() : Is a Gear symbol - coordinates : " + entrySymbol.getKey());
				
				//Tester les 8 positions autour du symbol et si on trouve un nombre, alors l'ajouter au total puis l'effacer de la map
				listGroupsAdjacentToAGearSymbol = new ArrayList<SchematicElementGroup>();
				
				//Tester sur la même ligne
				if(schematicByGroupsPerLine.containsKey(entrySymbol.getKey().getCoordX()) && !schematicByGroupsPerLine.get(entrySymbol.getKey().getCoordX()).isEmpty()) {				
					for(SchematicElementGroup entryGroup : schematicByGroupsPerLine.get(entrySymbol.getKey().getCoordX())) {
						if(entryGroup.isAdjacentToUnit(entrySymbol.getKey())) {
							listGroupsAdjacentToAGearSymbol.add(entryGroup);
						} 
					}			
				}
				
				//Tester la ligne du dessus
				if(schematicByGroupsPerLine.containsKey(entrySymbol.getKey().getCoordX() + 1) && !schematicByGroupsPerLine.get(entrySymbol.getKey().getCoordX() + 1).isEmpty()) {
					for(SchematicElementGroup entryGroup : schematicByGroupsPerLine.get(entrySymbol.getKey().getCoordX() + 1)) {
						if(entryGroup.isAdjacentToUnit(entrySymbol.getKey())) {
							listGroupsAdjacentToAGearSymbol.add(entryGroup);
						} 
					}
				}
				
				//Tester la ligne d'en dessous
				if(schematicByGroupsPerLine.containsKey(entrySymbol.getKey().getCoordX() - 1) && !schematicByGroupsPerLine.get(entrySymbol.getKey().getCoordX() - 1).isEmpty()) {
					for(SchematicElementGroup entryGroup : schematicByGroupsPerLine.get(entrySymbol.getKey().getCoordX() - 1)) {
						if(entryGroup.isAdjacentToUnit(entrySymbol.getKey())) {
							listGroupsAdjacentToAGearSymbol.add(entryGroup);
						}
					}
				}
				
				
				//Si il y a seulement deux nombres autour du symbole, alors c'est un gear et on ajoute la valeur des nombres
				if(listGroupsAdjacentToAGearSymbol.size() == 2)
					resultTotal += Integer.parseInt(listGroupsAdjacentToAGearSymbol.get(0).getValue()) * Integer.parseInt(listGroupsAdjacentToAGearSymbol.get(1).getValue());				
			}
		}
		
		return resultTotal;
	}
	
	public static void main(String[] args) throws Exception {
		/*ArrayList<Integer> liste = new ArrayList<Integer>();
		Integer elementACopier = 5;
		liste.add(elementACopier);

		elementACopier = null;

		System.out.println(elementACopier == null); //devrait être null = true
		System.out.println(liste.get(0) == null); //doit garder la valeur 5 = false */
		
		convertInput();
		
		//Efface la map principale ??
		//int resultV1 = calcPartNumbers();
		//System.out.println("Result V1 : " + resultV1);
		
		int resultV2 = calcGearsNumbers();
		System.out.println("Result V2 : " + resultV2);
	}	
	
}
