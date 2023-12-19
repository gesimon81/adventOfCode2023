package day4;

import java.util.ArrayList;
import java.util.Scanner;

public class Scratchcard {

	/**
	 * Numéro de la carte
	 */
	private int cardId;
	
	/**
	 * Liste des nombres gagnants
	 */
	private ArrayList<Integer> listWinningNumbers;
	
	/**
	 * Liste des nombres possédés
	 */
	private ArrayList<Integer> listHaveNumbers;
	
	public Scratchcard(int cardId) {
		this.cardId = cardId;
		
		this.listWinningNumbers = new ArrayList<Integer>();
		this.listHaveNumbers = new ArrayList<Integer>();
	}
	
	public Scratchcard(int cardId, ArrayList<Integer> winningNumbers, ArrayList<Integer> haveNumbers) {
		this.cardId = cardId;
		
		this.listWinningNumbers = winningNumbers;
		this.listHaveNumbers = haveNumbers;
	}

	public int getCardId() {
		return cardId;
	}

	public void setCardId(int cardId) {
		this.cardId = cardId;
	}

	public ArrayList<Integer> getListWinningNumbers() {
		return listWinningNumbers;
	}

	public void setListWinningNumbers(ArrayList<Integer> listWinningNumbers) {
		this.listWinningNumbers = listWinningNumbers;
	}

	public ArrayList<Integer> getListHaveNumbers() {
		return listHaveNumbers;
	}

	public void setListHaveNumbers(ArrayList<Integer> listHaveNumbers) {
		this.listHaveNumbers = listHaveNumbers;
	}
	
	/**
	 * Retourne le nombre de nombres possédés matchant avec les nombres gagnants
	 * @return
	 */
	public int calcNbMatchingNumbers() {
		int totalMatchingNumbers = 0;
		
		for(Integer haveNumber : this.listHaveNumbers) {
			if(this.listWinningNumbers.contains(haveNumber))
				totalMatchingNumbers++;
		}
		
		return totalMatchingNumbers;
	}
	
	/**
	 * Calcule la valeur de la carte en points
	 * @return le total des points
	 */
	public int calcScratchcardPoints() {
		int nbMatchingNumbers = this.calcNbMatchingNumbers();
		
		int totalPoints;
		
		if (nbMatchingNumbers <= 0) {
	        totalPoints = 0;
	    } else {
	        totalPoints = (int) Math.pow(2, nbMatchingNumbers - 1);
	    }
		
		return totalPoints;
	}
	
	
	/**
	 * Retourne une carte sous la forme "Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53"
	 */
	@Override
	public String toString() {
		String str = "Card " + this.cardId + ":";
		
		for(Integer winningNumber : this.listWinningNumbers) {
			str += " " + winningNumber;
		}
		
		str += " |";
		
		for(Integer haveNumber : this.listHaveNumbers) {
			str += " " + haveNumber;
		}
		
		return str;
	}
	
	/**
	 * Extrait les données d'une chaîne sous la forme "Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53" pour construire une Scratchcard
	 * @param inputLine : données de l'input sous la forme "Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53"
	 * @return la nouvelle Scratchcard
	 */
	public static Scratchcard constructScratchcardFromInput(String inputLine) throws IllegalArgumentException {
		if(!inputLine.startsWith("Card "))
			throw new IllegalArgumentException("constructScratchcardFromInput(): L'input n'est pas une carte - input: '" + inputLine + "'");
		
		
		// Séparation de la ligne entre le numéro de la carte et la liste des nombres
		String[] elementsCardAndNumbers = inputLine.split(": ");
		// Séparation de la ligne entre les différents lots de nombres
		String[] elementsNumbers = elementsCardAndNumbers[1].split(" \\| ");
		
		//Séparation de chaque lots de nombre en nombre séparés
		String[] elementsWinningNumbers = elementsNumbers[0].trim().split(" ");
		String[] elementsHaveNumbers = elementsNumbers[1].trim().split(" ");
		

		//Extraction des données
		int idCard = Integer.parseInt(elementsCardAndNumbers[0].substring(5).trim());
		
		ArrayList<Integer> winningNumbers = new ArrayList<Integer>();
		for(int i = 0; i < elementsWinningNumbers.length; i++) {
			if(!elementsWinningNumbers[i].contentEquals(""))
				winningNumbers.add(Integer.parseInt(elementsWinningNumbers[i]));
		}
		
		ArrayList<Integer> haveNumbers = new ArrayList<Integer>();
		for(int i = 0; i < elementsHaveNumbers.length; i++) {
			if(!elementsHaveNumbers[i].contentEquals(""))
			haveNumbers.add(Integer.parseInt(elementsHaveNumbers[i]));
		}
		
		
		Scratchcard resultScratchard = new Scratchcard(idCard, winningNumbers, haveNumbers);
		return resultScratchard;
	}
}
