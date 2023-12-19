package day4;

import java.util.Map;
import java.util.TreeMap;

public class MainDay4 {

	public static boolean isDebug = false;
	
	/**
	 * Représentation de l'input
	 * {numéro de la carte, carte}
	 */
	public static TreeMap<Integer, Scratchcard> mapScratchcard;
	
	/**
	 * Transforme les données de l'input en objets Scratchcard
	 * @throws Exception
	 */
	public static void convertInput() throws Exception {
		// Séparation de l'entrée en lignes
        String[] lines;
        if(isDebug) {
        	lines = InputDay4.INPUT_DAY4_TEST.split("\r\n");
        } else {
        	lines = InputDay4.INPUT_DAY4.split("\r\n");
        }
		
		mapScratchcard = new TreeMap<Integer, Scratchcard>();
		
		
		//Parcours de chaque ligne et transformation en Scratchcard
		//Carte parcourue actuellement
		Scratchcard card;
		
		for(int indexLine = 0; indexLine < lines.length; indexLine++) {
			card = Scratchcard.constructScratchcardFromInput(lines[indexLine]);
			mapScratchcard.put(card.getCardId(), card);
		}
	}
	
	/**
	 * V1 Calcule le nombre de points total en additionnant la valeur de chaque carte
	 * @return
	 */
	public static int calcScratchcardsPileWorth() {
		int totalPoints = 0;
		
		for (Map.Entry<Integer, Scratchcard> entryCard: mapScratchcard.entrySet()) {
			totalPoints += entryCard.getValue().calcScratchcardPoints();
		}

		return totalPoints;
	}
	
	/**
	 * V2 Calcule le nombre de cartes obtenues (originales et copies)
	 * @return
	 */
	public static int calcNbScratchcardsObtained() {
		int totalNbCards = 0;
		
		//TODO
		//{index Carte, nb copies de la carte}
		TreeMap<Integer, Integer> mapScratchcardNbInstances = new TreeMap<Integer, Integer>();
		
		//Créer la map et tous les index
		for(int indexCard = 1; indexCard <= mapScratchcard.size(); indexCard++) {
			mapScratchcardNbInstances.put(indexCard, 1);
		}
		
		
		//Pour chaque carte, calculer le nombre de cartes gagnées sur l'index suivant
		int nbMatchingNumbers;
		int nbCardsWon; //Combien de fois la carte actuelle est-elle présente 
		
		for(int indexCard = 1; indexCard <= mapScratchcard.size(); indexCard++) {
			//Calculer le nombre de cartes gagnées
			nbMatchingNumbers = mapScratchcard.get(indexCard).calcNbMatchingNumbers();
			
			//Incrémenter le nombre de cartes pour les copies gagnées
			if(nbMatchingNumbers > 0) {
				for(int indexCardWon = 1; indexCardWon <= nbMatchingNumbers; indexCardWon++) {
					nbCardsWon = mapScratchcardNbInstances.get(indexCard);
					mapScratchcardNbInstances.put(indexCard + indexCardWon, mapScratchcardNbInstances.get(indexCard + indexCardWon) + nbCardsWon);
				}
			} 
			
			
			//Modifier le score
			totalNbCards += mapScratchcardNbInstances.get(indexCard);
			System.out.println("calcNbScratchcardsObtained(): index " + indexCard + ": nb cartes=" + mapScratchcardNbInstances.get(indexCard));
		}
		
		return totalNbCards;
		
	}
		
	public static void main(String[] args) throws Exception {
		convertInput();

		int resultV1 = calcScratchcardsPileWorth();
		System.out.println("Result V1 : " + resultV1);
		
		int resultV2 = calcNbScratchcardsObtained();
		System.out.println("Result V2 : " + resultV2);
	}

}
