package day7V2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class MainDay7 {
	public static boolean isDebug = false;
	
	public static LinkedList<Bid> listHandsAndBids;
	
	public static ArrayList<Bid> listBidsRanked;
	
	/**
	 * Convertit les données de l'énoncée
	 * @throws Exception
	 */
	public static void convertInput() throws Exception {
		// Séparation de l'entrée en lignes
        String[] lines;
        if(isDebug) {
        	lines = InputDay7.INPUT_DAY7_TEST.split("\r\n");
        } else {
        	lines = InputDay7.INPUT_DAY7.split("\r\n");
        }
        
        listHandsAndBids = new LinkedList<Bid>();
        
        //Séparation des lignes entre la composition des mains et le montant du pari
        String[] handsAndBids;

        for(int indexLine = 0; indexLine < lines.length; indexLine++) {
        	handsAndBids = lines[indexLine].split(" ");
        	
        	//Construction de la main
        	listHandsAndBids.add(new Bid(Hand.constructHandFromInput(handsAndBids[0]), Integer.parseInt(handsAndBids[1])));
        }
        
	}
	
	/**
	 * Crée une liste ordonnée par les rangs
	 * @throws IllegalArgumentException
	 * @throws Exception
	 */
	public static void rankAllBids() throws IllegalArgumentException, Exception {		
		//Ordonner par rang
		listBidsRanked = new ArrayList<Bid>();

		//parcourir les mains à ajouter
		for(Bid bid : listHandsAndBids) {
			listBidsRanked.add(bid);
		}
		
		Collections.sort(listBidsRanked);
	}
	

	
	/**
	 * Classe toutes les mains avant d'attribuer un rang à chacune et de calculer les points totaux
	 * @return les gains totaux
	 * @throws IllegalArgumentException
	 * @throws Exception
	 */
	public static int calcTotalWinnings() throws IllegalArgumentException, Exception {
		//Créer le classement
		rankAllBids();
		
		
		//Calculer les gains
		int resultWinnings = 0;
		int indexRank = 1;
		
		for(Bid bid : listBidsRanked) {
			//System.out.println("Bid rank=" + indexRank + "; main (" + bid.getHand() + ") et type de main :" +  bid.getHand().getHandType());
			
			resultWinnings += bid.getBidValue() * indexRank;
			
			indexRank++;
		}
		
		return resultWinnings;
	}
	
	public static void main(String[] args) throws Exception {
		convertInput();
		
		int resultV2 = calcTotalWinnings();
		System.out.println("Result V2 = " + resultV2);
		
	}

}
