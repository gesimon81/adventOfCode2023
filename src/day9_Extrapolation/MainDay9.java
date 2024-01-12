package day9_Extrapolation;

import java.util.ArrayList;
import java.util.LinkedList;


public class MainDay9 {
	public static boolean isDebug = false;
	
	public static ArrayList<History> listHistory;
	
	/**
	 * Transforme les données de l'input en objets History
	 * @throws Exception
	 */
	public static void convertInput() throws Exception {
		// Séparation de l'entrée en lignes
        String[] lines;
        if(isDebug) {
        	lines = InputDay9.INPUT_DAY9_TEST.split("\r\n");
        } else {
        	lines = InputDay9.INPUT_DAY9.split("\r\n");
        }
        
        
        listHistory = new ArrayList<History>();
        String[] values;
        LinkedList<Integer> listValues;
        
        for(int indexLine = 0; indexLine < lines.length; indexLine++) {
        	//Récupérer les valeurs de l'historique
        	values = lines[indexLine].split(" ");
        	listValues = new LinkedList<Integer>();
        	
        	for(int indexValue = 0; indexValue < values.length; indexValue++) {
        		listValues.add(Integer.parseInt(values[indexValue]));
        	}
        	
        	//Créer l'objet History
        	listHistory.add(new History(listValues));
        }
	}
	
	public static int calcSumExtrapolatedNextValues() {
		int result = 0;
		
		int nextValueExtrapolated;
		
		for(History history : listHistory) {
			nextValueExtrapolated = history.extrapolateNextValue();
			
			System.out.println("nextValueExtrapolated = " + nextValueExtrapolated);
			
			result += nextValueExtrapolated;
		}
		
		return result;
	}
	
	public static int calcSumExtrapolatedPreviousValues() {
		int result = 0;
		
		int previousValueExtrapolated;
		
		for(History history : listHistory) {
			previousValueExtrapolated = history.extrapolatePreviousValue();
			
			System.out.println("previousValueExtrapolated = " + previousValueExtrapolated);
			
			result += previousValueExtrapolated;
		}
		
		return result;
	}
	
	public static void main(String[] args) throws Exception {
		//V1
		convertInput();
		
		int resultV1 = calcSumExtrapolatedNextValues();
		System.out.println("Result final V1 = " + resultV1);
		
		//clear
		listHistory.clear();
		
		//V2
		convertInput();
		
		int resultV2 = calcSumExtrapolatedPreviousValues();
		System.out.println("Result final V2 = " + resultV2);
	}
}
