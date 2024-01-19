package day10_Pathfinding;

import java.util.HashMap;
import java.util.Map;


public class MainDay10 {

	public static boolean isDebug = true;
	
	public static String inputTest = InputDay10.INPUT_DAY10_TEST1;
	//public static String inputTest = InputDay10.INPUT_DAY10_TEST2;
	
	/**
	 * Garde en mémoire l'ensemble des tuyaux et de leurs coordonnées
	 */
	private static HashMap<Coordinate, Pipe> mapAllPipes;

	/**
	 * Garde en mémoire le pipe de départ pour faciliter l'accès ultérieur
	 */
	private static Pipe startingPipe;
	
	private static int sizeSchemaX; // ne pas lire en graphique, X = lignes du tableau, Y = colonne du tableau
	private static int sizeSchemaY;
	
	/**
	 * Convertit les données de l'énoncé vers la map mapAllPipes
	 * @throws Exception
	 */
	public static void convertInput() throws Exception {
		// Séparation de l'entrée en lignes
        String[] lines;
        if(isDebug) {
        	lines = inputTest.split("\r\n");
        } else {
        	lines = InputDay10.INPUT_DAY10.split("\r\n");
        }
        
        //définir les limites du tableau
        sizeSchemaX = lines.length;
        sizeSchemaY = lines[0].length();
        
        mapAllPipes = new HashMap<Coordinate, Pipe>();
        
        Coordinate coordinate;
        char[] tabChar;
        
        Coordinate startingPipeCoordinates = null;
        
        for(int indexLine = 0; indexLine < lines.length; indexLine++) {
        	tabChar = lines[indexLine].toCharArray();
        	for(int indexColumn = 0; indexColumn < tabChar.length; indexColumn++) {
        		coordinate = new Coordinate(indexLine, indexColumn);
        		
        		if(tabChar[indexColumn] == 'S') {
        			startingPipeCoordinates = coordinate;
        		} else {
            		mapAllPipes.put(coordinate, new Pipe(coordinate, String.valueOf(tabChar[indexColumn])));
        		}
        	}
        }
        
        //Créer le starting pipe
        startingPipe =  createStartingPipe(startingPipeCoordinates);
        mapAllPipes.put(startingPipeCoordinates, startingPipe);
        
        
        
        //Associer les pipes 
    	associatePipesWithNextPipes();
    	
    	
    	System.out.println("ConvertInput() done");
	}
	
	/**
	 * associer les pipes avec leur adjacents (si possible)
	 */
	private static void associatePipesWithNextPipes() {
		Pipe pipeNext;
		Pipe currentPipe; //pour debug
		
    	for(Map.Entry<Coordinate, Pipe> pipeEntry : mapAllPipes.entrySet()) {
    		if(!pipeEntry.getKey().equals(startingPipe.getCoordinate())) {
    			currentPipe = pipeEntry.getValue();
    			
    			//Connexions N/S
        		switch(pipeEntry.getValue().getType()) {
	        		case VERTICAL_PIPE:	
	    	 			//Associer le firstNextPipe (N)
	    	    		if(pipeEntry.getKey().getCoordX() > 0) {
	    	    			pipeNext = mapAllPipes.get(new Coordinate(pipeEntry.getKey().getCoordX() - 1, pipeEntry.getKey().getCoordY()));
	    	    		
	    	    			//Si pipeNext != |, 7, F alors null
	    	    			if(pipeNext.getType().equals(PipeType.VERTICAL_PIPE) || pipeNext.getType().equals(PipeType.BEND90_SW) || pipeNext.getType().equals(PipeType.BEND90_SE)) {
	    	    				pipeEntry.getValue().setFirstPipe(pipeNext);
	    	    			} else {
	    	    				pipeEntry.getValue().setFirstPipe(null);
	    	    			}
	    	    		}
	    	    		
	    	    		//Associer le secondNextPipe (S)
	    	    		if(pipeEntry.getKey().getCoordX() < sizeSchemaX - 1) {
	    	    			pipeNext = mapAllPipes.get(new Coordinate(pipeEntry.getKey().getCoordX() + 1, pipeEntry.getKey().getCoordY()));
	    	    		
	    	    			//Si pipeNext != |, L, J alors null
	    	    			if(pipeNext.getType().equals(PipeType.VERTICAL_PIPE) || pipeNext.getType().equals(PipeType.BEND90_NW) || pipeNext.getType().equals(PipeType.BEND90_NE)) {
	    	    				pipeEntry.getValue().setSecondPipe(pipeNext);
	    	    			} else {
	    	    				pipeEntry.getValue().setSecondPipe(null);
	    	    			}
	    	    		}
	    	    		
	    	 			break;
	    	 		case HORIZONTAL_PIPE:
	    	 			//Associer le firstNextPipe (W)
	    	    		if(pipeEntry.getKey().getCoordY() > 0) {
	    	    			pipeNext = mapAllPipes.get(new Coordinate(pipeEntry.getKey().getCoordX(), pipeEntry.getKey().getCoordY() - 1));
	    	    		
	    	    			//Si pipeNext != -, L, F alors null
	    	    			if(pipeNext.getType().equals(PipeType.HORIZONTAL_PIPE) || pipeNext.getType().equals(PipeType.BEND90_NE) || pipeNext.getType().equals(PipeType.BEND90_SE)) {
	    	    				pipeEntry.getValue().setFirstPipe(pipeNext);
	    	    			} else {
	    	    				pipeEntry.getValue().setFirstPipe(null);
	    	    			}
	    	    		}
	    	    		
	    	    		//Associer le secondNextPipe (E)
	    	    		if(pipeEntry.getKey().getCoordY() < sizeSchemaY - 1) {
	    	    			pipeNext = mapAllPipes.get(new Coordinate(pipeEntry.getKey().getCoordX(), pipeEntry.getKey().getCoordY()  + 1));
	    	    		
	    	    			//Si pipeNext != -, J, 7 alors null
	    	    			if(pipeNext.getType().equals(PipeType.VERTICAL_PIPE) || pipeNext.getType().equals(PipeType.BEND90_NW) || pipeNext.getType().equals(PipeType.BEND90_SW)) {
	    	    				pipeEntry.getValue().setSecondPipe(pipeNext);
	    	    			} else {
	    	    				pipeEntry.getValue().setSecondPipe(null);
	    	    			}
	    	    		}
	    	    		
	    	 			break;
	    	 		case BEND90_NE: //L
	    	 			//Associer le firstNextPipe (N)
	    	    		if(pipeEntry.getKey().getCoordX() > 0) {
	    	    			pipeNext = mapAllPipes.get(new Coordinate(pipeEntry.getKey().getCoordX() - 1, pipeEntry.getKey().getCoordY()));
	    	    		
	    	    			//Si pipeNext != |, 7, F alors null
	    	    			if(pipeNext.getType().equals(PipeType.VERTICAL_PIPE) || pipeNext.getType().equals(PipeType.BEND90_SW) || pipeNext.getType().equals(PipeType.BEND90_SE)) {
	    	    				pipeEntry.getValue().setFirstPipe(pipeNext);
	    	    			} else {
	    	    				pipeEntry.getValue().setFirstPipe(null);
	    	    			}
	    	    		}
	    	    		
	    	    		//Associer le secondNextPipe (E)
	    	    		if(pipeEntry.getKey().getCoordY() < sizeSchemaY - 1) {
	    	    			pipeNext = mapAllPipes.get(new Coordinate(pipeEntry.getKey().getCoordX(), pipeEntry.getKey().getCoordY()  + 1));
	    	    		
	    	    			//Si pipeNext != -, J, 7 alors null
	    	    			if(pipeNext.getType().equals(PipeType.HORIZONTAL_PIPE) || pipeNext.getType().equals(PipeType.BEND90_NW) || pipeNext.getType().equals(PipeType.BEND90_SW)) {
	    	    				pipeEntry.getValue().setSecondPipe(pipeNext);
	    	    			} else {
	    	    				pipeEntry.getValue().setSecondPipe(null);
	    	    			}
	    	    		}
	    	    		
	    	 			break;
	    	 		case BEND90_NW: //J
	    	 			//Associer le firstNextPipe (N)
	    	    		if(pipeEntry.getKey().getCoordX() > 0) {
	    	    			pipeNext = mapAllPipes.get(new Coordinate(pipeEntry.getKey().getCoordX() - 1, pipeEntry.getKey().getCoordY()));
	    	    		
	    	    			//Si pipeNext != |, 7, F alors null
	    	    			if(pipeNext.getType().equals(PipeType.VERTICAL_PIPE) || pipeNext.getType().equals(PipeType.BEND90_SW) || pipeNext.getType().equals(PipeType.BEND90_SE)) {
	    	    				pipeEntry.getValue().setFirstPipe(pipeNext);
	    	    			} else {
	    	    				pipeEntry.getValue().setFirstPipe(null);
	    	    			}
	    	    		}
	    	    		
	    	    		//Associer le secondNextPipe (W)
	    	    		if(pipeEntry.getKey().getCoordY() > 0) {
	    	    			pipeNext = mapAllPipes.get(new Coordinate(pipeEntry.getKey().getCoordX(), pipeEntry.getKey().getCoordY() - 1));
	    	    		
	    	    			//Si pipeNext != -, L, F alors null
	    	    			if(pipeNext.getType().equals(PipeType.HORIZONTAL_PIPE) || pipeNext.getType().equals(PipeType.BEND90_NE) || pipeNext.getType().equals(PipeType.BEND90_SE)) {
	    	    				pipeEntry.getValue().setSecondPipe(pipeNext);
	    	    			} else {
	    	    				pipeEntry.getValue().setSecondPipe(null);
	    	    			}
	    	    		}
	    	 			break;
	    	 		case BEND90_SW: //7
	    	 			//Associer le firstNextPipe (S)
	    	    		if(pipeEntry.getKey().getCoordX() < sizeSchemaX - 1) {
	    	    			pipeNext = mapAllPipes.get(new Coordinate(pipeEntry.getKey().getCoordX() + 1, pipeEntry.getKey().getCoordY()));
	    	    		
	    	    			//Si pipeNext != |, L, J alors null
	    	    			if(pipeNext.getType().equals(PipeType.VERTICAL_PIPE) || pipeNext.getType().equals(PipeType.BEND90_NW) || pipeNext.getType().equals(PipeType.BEND90_NE)) {
	    	    				pipeEntry.getValue().setFirstPipe(pipeNext);
	    	    			} else {
	    	    				pipeEntry.getValue().setFirstPipe(null);
	    	    			}
	    	    		}
	    	 			
	    	 			//Associer le secondNextPipe (W)
	    	    		if(pipeEntry.getKey().getCoordY() > 0) {
	    	    			pipeNext = mapAllPipes.get(new Coordinate(pipeEntry.getKey().getCoordX(), pipeEntry.getKey().getCoordY() - 1));
	    	    		
	    	    			//Si pipeNext != -, L, F alors null
	    	    			if(pipeNext.getType().equals(PipeType.HORIZONTAL_PIPE) || pipeNext.getType().equals(PipeType.BEND90_NE) || pipeNext.getType().equals(PipeType.BEND90_SE)) {
	    	    				pipeEntry.getValue().setSecondPipe(pipeNext);
	    	    			} else {
	    	    				pipeEntry.getValue().setSecondPipe(null);
	    	    			}
	    	    		}
	    	 			break;
	    	 		case BEND90_SE: //F
	    	 			//Associer le firstNextPipe (S)
	    	    		if(pipeEntry.getKey().getCoordX() < sizeSchemaX - 1) {
	    	    			pipeNext = mapAllPipes.get(new Coordinate(pipeEntry.getKey().getCoordX() + 1, pipeEntry.getKey().getCoordY()));
	    	    		
	    	    			//Si pipeNext != |, L, J alors null
	    	    			if(pipeNext.getType().equals(PipeType.VERTICAL_PIPE) || pipeNext.getType().equals(PipeType.BEND90_NW) || pipeNext.getType().equals(PipeType.BEND90_NE)) {
	    	    				pipeEntry.getValue().setFirstPipe(pipeNext);
	    	    			} else {
	    	    				pipeEntry.getValue().setFirstPipe(null);
	    	    			}
	    	    		}
	    	    		
	    	    		//Associer le secondNextPipe (E)
	    	    		if(pipeEntry.getKey().getCoordY() < sizeSchemaY - 1) {
	    	    			pipeNext = mapAllPipes.get(new Coordinate(pipeEntry.getKey().getCoordX(), pipeEntry.getKey().getCoordY()  + 1));
	    	    		
	    	    			//Si pipeNext != -, J, 7 alors null
	    	    			if(pipeNext.getType().equals(PipeType.VERTICAL_PIPE) || pipeNext.getType().equals(PipeType.BEND90_NW) || pipeNext.getType().equals(PipeType.BEND90_SW)) {
	    	    				pipeEntry.getValue().setSecondPipe(pipeNext);
	    	    			} else {
	    	    				pipeEntry.getValue().setSecondPipe(null);
	    	    			}
	    	    		}
	    	 			break;
	    	 		case GROUND:
	    	 			pipeEntry.getValue().setFirstPipe(null);			
	    	 			pipeEntry.getValue().setSecondPipe(null);
	    	 			
	    	 			break;
        		}
    		}
    		
    	}
    }
		
	/**
	 * Crée le pipe de départ, en le liant avec les deux pipes suivants
	 * @param coordinate
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	private static Pipe createStartingPipe(Coordinate coordinate) throws Exception {
		//Tester les 4 positions cardinales autour. Si plus de deux résultats ouverts, alors il y a une erreur
		
		Pipe firstNextPipe = null;
		Pipe secondNextPipe = null;
		
		//Si x = 0, pas de W
		//Si x = sizeSchemaX - 1, pas de E
		//Si y = 0, pas de N
		//Si y = sizeSchemaX - 1, pas de S
		
		Pipe pipeToTest;
		
		//Position N -> |, 7, F
		if(coordinate.getCoordX() > 0) {
			pipeToTest = mapAllPipes.get(new Coordinate(coordinate.getCoordX() - 1, coordinate.getCoordY()));
			
			if(pipeToTest.getType().equals(PipeType.VERTICAL_PIPE) || pipeToTest.getType().equals(PipeType.BEND90_SW) || pipeToTest.getType().equals(PipeType.BEND90_SE)) {
				if(firstNextPipe == null) {
					firstNextPipe = pipeToTest;
				} else if(secondNextPipe == null) {
					secondNextPipe = pipeToTest;
				} else {
					throw new Exception("Le starting pipe n'a pas pu être placé, au moins 3 accès");
				}
			}
		}
		
		//Position S -> |, L, J
		if(coordinate.getCoordX() < sizeSchemaX - 1) {
			pipeToTest = mapAllPipes.get(new Coordinate(coordinate.getCoordX() + 1, coordinate.getCoordY()));
			
			if(pipeToTest.getType().equals(PipeType.VERTICAL_PIPE) || pipeToTest.getType().equals(PipeType.BEND90_NW) || pipeToTest.getType().equals(PipeType.BEND90_NE)) {
				if(firstNextPipe == null) {
					firstNextPipe = pipeToTest;
				} else if(secondNextPipe == null) {
					secondNextPipe = pipeToTest;
				} else {
					throw new Exception("Le starting pipe n'a pas pu être placé, au moins 3 accès");
				}
			}
		}
		
		//Position W -> -, L, F
		if(coordinate.getCoordY() > 0) {
			pipeToTest = mapAllPipes.get(new Coordinate(coordinate.getCoordX(), coordinate.getCoordY() - 1));
			
			if(pipeToTest.getType().equals(PipeType.HORIZONTAL_PIPE) || pipeToTest.getType().equals(PipeType.BEND90_NE) || pipeToTest.getType().equals(PipeType.BEND90_SE)) {
				if(firstNextPipe == null) {
					firstNextPipe = pipeToTest;
				} else if(secondNextPipe == null) {
					secondNextPipe = pipeToTest;
				} else {
					throw new Exception("Le starting pipe n'a pas pu être placé, au moins 3 accès");
				}
			}
		}
		
		//Position E -> -, J, 7
		if(coordinate.getCoordY() < sizeSchemaY - 1) {
			pipeToTest = mapAllPipes.get(new Coordinate(coordinate.getCoordX(), coordinate.getCoordY() + 1));
			
			if(pipeToTest.getType().equals(PipeType.HORIZONTAL_PIPE) || pipeToTest.getType().equals(PipeType.BEND90_NW) || pipeToTest.getType().equals(PipeType.BEND90_SW)) {
				if(firstNextPipe == null) {
					firstNextPipe = pipeToTest;
				} else if(secondNextPipe == null) {
					secondNextPipe = pipeToTest;
				} else {
					throw new Exception("Le starting pipe n'a pas pu être placé, au moins 3 accès");
				}
			}
		}
		
	
		
		//Créer le nouveau pipe
		PipeType startingPipeType = determinePipeTypeByTwoNextPipes(coordinate, firstNextPipe, secondNextPipe);
		Pipe startingPipeToCreate = new Pipe(coordinate, startingPipeType);
		
		startingPipeToCreate.setFirstPipe(firstNextPipe);
		startingPipeToCreate.setSecondPipe(secondNextPipe);
		
		return startingPipeToCreate;
	}
	
	/**
	 * !!! Teste seulement les coordonnées, il faut avoir tester avant que les 2 nextPipes soient correctes
	 * @param coordPipe
	 * @param firstNextPipe
	 * @param secondNextPipe
	 * @return
	 * @throws Exception
	 */
	public static PipeType determinePipeTypeByTwoNextPipes(Coordinate coordPipe, Pipe firstNextPipe, Pipe secondNextPipe) throws Exception {
		PipeType pipeType;
		
		// il faut associer la position de 1 et 2 avec la position de S, car plusieurs cas où 1/2 sont identiques
		//si les deux pipes sont sur la même ligne ou la même colonne = - ou |
		if(firstNextPipe.getCoordinate().getCoordX() == secondNextPipe.getCoordinate().getCoordX()) {
			pipeType = PipeType.HORIZONTAL_PIPE;
		} else if(firstNextPipe.getCoordinate().getCoordY() == secondNextPipe.getCoordinate().getCoordY()) {
			pipeType = PipeType.VERTICAL_PIPE;
		} else 	if(firstNextPipe.getCoordinate().getCoordX() == secondNextPipe.getCoordinate().getCoordX() - 1 && firstNextPipe.getCoordinate().getCoordY() == secondNextPipe.getCoordinate().getCoordY() - 1) {
			if(coordPipe.getCoordX() == firstNextPipe.getCoordinate().getCoordX()) {
				//7 is a 90-degree bend connecting south and west.
				//1	S		
				//	2		
				pipeType = PipeType.BEND90_SW;
			} else {
				//L is a 90-degree bend connecting north and east.
				//1			
				//S 2		
				pipeType = PipeType.BEND90_NE;
			}
		} else 	if(firstNextPipe.getCoordinate().getCoordX() == secondNextPipe.getCoordinate().getCoordX() + 1 && firstNextPipe.getCoordinate().getCoordY() == secondNextPipe.getCoordinate().getCoordY() + 1) {
			if(coordPipe.getCoordX() == firstNextPipe.getCoordinate().getCoordX()) {
				//L is a 90-degree bend connecting north and east.
				//2			
				//S 1		
				pipeType = PipeType.BEND90_NE;
			} else {
				//7 is a 90-degree bend connecting south and west.
				//2	S		
				//	1		
				pipeType = PipeType.BEND90_SW;
			}
		} else 	if(firstNextPipe.getCoordinate().getCoordX() == secondNextPipe.getCoordinate().getCoordX() - 1 && firstNextPipe.getCoordinate().getCoordY() == secondNextPipe.getCoordinate().getCoordY() + 1) {			
			if(coordPipe.getCoordX() == firstNextPipe.getCoordinate().getCoordX()) {
				//F is a 90-degree bend connecting south and east.
				//S	1		
				//2			
				pipeType = PipeType.BEND90_SE;
			} else {
				//J is a 90-degree bend connecting north and west.
				//	1			
				//2 S		
				pipeType = PipeType.BEND90_NW;
			}
		} else 	if(firstNextPipe.getCoordinate().getCoordX() == secondNextPipe.getCoordinate().getCoordX() + 1 && firstNextPipe.getCoordinate().getCoordY() == secondNextPipe.getCoordinate().getCoordY() - 1) {
			if(coordPipe.getCoordX() == firstNextPipe.getCoordinate().getCoordX()) {
				//J is a 90-degree bend connecting north and west.
				//	2
				//1	S
				pipeType = PipeType.BEND90_NW;
			} else {
				//F is a 90-degree bend connecting south and east.
				//S	2
				//1
				pipeType = PipeType.BEND90_SE;
			}
		} else {
			throw new Exception(" pipe type non déterminé");
		}
		
		return pipeType;
	}
	
	/**
	 * Représentation du schéma
	 */
	public static void toStringSchema() {
		System.out.println("Schéma complet :");
		String str;
		
		Pipe pipeToDisplay;
		
		for(int indexLine = 0; indexLine < sizeSchemaX; indexLine++) {
			str = "";
			for(int indexColumn = 0; indexColumn < sizeSchemaY; indexColumn++) {
				pipeToDisplay = mapAllPipes.get(new Coordinate(indexLine, indexColumn));
				
				if(pipeToDisplay == startingPipe) {
					str += "S";
				} else {
					str += PipeType.getStringByPipeType(pipeToDisplay.getType());	
				}
				
			}
			
			System.out.println(str);
		}
	}
	
	
	/**
	 * Générer le schéma en supprimant tous les éléments n'appartenant pas à la boucle principale
	 * @return
	 * @throws Exception 
	 */
	public static HashMap<Coordinate, Pipe> generateMainLoop() throws Exception {
		HashMap<Coordinate, Pipe> mainLoop = new HashMap<Coordinate, Pipe>();
		
		
		mainLoop.put(startingPipe.getCoordinate(), startingPipe);
		
		Coordinate coordNext = startingPipe.getFirstPipe().getCoordinate();
		Coordinate coordEnd = startingPipe.getSecondPipe().getCoordinate();
		//Coordinate coordEnd = startingPipe.getCoordinate();
		Pipe currentPipe = null;
	
		
		while(!coordNext.equals(coordEnd)) {
			currentPipe = mapAllPipes.get(coordNext);
			
			if(currentPipe.getFirstPipe() == null || currentPipe.getSecondPipe() == null)
				throw new Exception("Erreur main loop avec un pipe à un sens");
			
			//Explorer le premier pipe
			if(!mainLoop.containsKey(currentPipe.getFirstPipe().getCoordinate())) {
				coordNext = currentPipe.getFirstPipe().getCoordinate();
				mainLoop.put(currentPipe.getCoordinate(), currentPipe);
			}
			
			//Explorer le second pipe
			if(!mainLoop.containsKey(currentPipe.getSecondPipe().getCoordinate())) {
				coordNext = currentPipe.getSecondPipe().getCoordinate();
				mainLoop.put(currentPipe.getCoordinate(), currentPipe);
			}
			
			
		}
		
		//Ajouter le dernier élément parcouru
		mainLoop.put(startingPipe.getSecondPipe().getCoordinate(), mapAllPipes.get(startingPipe.getSecondPipe().getCoordinate()));
		
		System.out.println("Main loop taille = " + mainLoop.size());
		
		for(Map.Entry<Coordinate, Pipe> pipeEntry : mainLoop.entrySet()) {
			System.out.println("Main loop " + pipeEntry.getKey() + " = " + PipeType.getStringByPipeType(pipeEntry.getValue().getType()));
		}
		
		return mainLoop;
	}
	
	
	public static void main(String[] args) throws Exception {
		convertInput();
		
		toStringSchema();
		
		for(Map.Entry<Coordinate, Pipe> pipeEntry : mapAllPipes.entrySet()) {
			System.out.println("All pipes " + pipeEntry.getKey() + " = " + PipeType.getStringByPipeType(pipeEntry.getValue().getType()));
		}
		
		generateMainLoop();
	} 
}
