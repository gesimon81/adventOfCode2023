package day6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MainDay6 {

	public static boolean isDebug = false;
	
	public static ArrayList<Race> listRaces;
	
	public static void convertInput(boolean isV1) throws Exception {
		// Séparation de l'entrée en lignes
		List<List<Long>> valuesRaces;
		if(isV1) {
			if(isDebug) {
	        	valuesRaces = extractNumericValues(InputDay6.INPUT_DAY6_TEST);
	        } else {
	        	valuesRaces = extractNumericValues(InputDay6.INPUT_DAY6);
	        }
		} else {
			if(isDebug) {
	        	valuesRaces = extractNumericValues(InputDay6.INPUT_DAY6_V2_TEST);
	        } else {
	        	valuesRaces = extractNumericValues(InputDay6.INPUT_DAY6_V2);
	        }
		}
        
		
        //Création des courses
		listRaces = new ArrayList<Race>();
		
		for(int indexRace = 0; indexRace < valuesRaces.get(0).size(); indexRace++) {
			listRaces.add(new Race(valuesRaces.get(0).get(indexRace), valuesRaces.get(1).get(indexRace)));
		}
		
		System.out.println("");
	}
	
	public static List<List<Long>> extractNumericValues(String input) {
        List<List<Long>> result = new ArrayList<>();

        try (Scanner scanner = new Scanner(input)) {
            while (scanner.hasNextLine()) {
            	
                scanner.next(); // Ignorer la première partie de la ligne (le nom de la propriété)
                List<Long> rowValues = new ArrayList<>();

                while (scanner.hasNextLong()) {
                    rowValues.add(scanner.nextLong());
                }

               
                result.add(rowValues);
            	if(scanner.hasNext()) 
            		scanner.nextLine(); // Aller à la ligne suivante
            }
        }

        return result;
    }
	
	public static int calcProductNbWaysToWin() {
		int result = 1;
		
		for(Race race : listRaces) {
			result *= race.nbWaysToWin();
		}
		
		return result;
	}
	
	public static void main(String[] args) throws Exception {
		
		/*convertInput(true);
		int resultV1 = calcProductNbWaysToWin();
		System.out.println("Result V1 : " + resultV1);
		*/
		convertInput(false);
		int resultV2 = calcProductNbWaysToWin();
		System.out.println("Result V2 : " + resultV2);
	}

}
