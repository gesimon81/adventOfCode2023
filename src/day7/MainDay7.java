package day7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class MainDay7 {
	public static boolean isDebug = true;
	
	public static LinkedList<Bid> listHandsAndBids;
	
	public static ArrayList<Bid> listBidsRanked;
	
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
	
	public static void rankAllBids() throws IllegalArgumentException, Exception {
		//Trier les mains selon les types
		/*LinkedList<Bid> bidsHighValue = new LinkedList<Bid>();
		LinkedList<Bid> bidsOnePair = new LinkedList<Bid>();
		LinkedList<Bid> bidsTwoPair = new LinkedList<Bid>();
		LinkedList<Bid> bidsThreeOfAKind = new LinkedList<Bid>();
		LinkedList<Bid> bidsFullHouse = new LinkedList<Bid>();
		LinkedList<Bid> bidsFourOfAKind = new LinkedList<Bid>();
		LinkedList<Bid> bidsFiveOfAKind = new LinkedList<Bid>();

		for(Bid bid : mapHandsAndBids) {
			if(bid.getHand().getHandType() == null)
				bid.getHand().generateHandType();
			
			switch(bid.getHand().getHandType().getValue()) {
				case 1:
					bidsHighValue.add(bid);
					break;
				case 2:
					bidsOnePair.add(bid);
					break;
				case 3:
					bidsTwoPair.add(bid);
					break;
				case 4:
					bidsThreeOfAKind.add(bid);
					break;
				case 5:
					bidsFullHouse.add(bid);
					break;
				case 6:
					bidsFourOfAKind.add(bid);
					break;
				case 7:
					bidsFiveOfAKind.add(bid);
					break;
			}
		}*/
		
		//Ordonner par rang
		listBidsRanked = new ArrayList<Bid>();
		
		int indexRank = 1;

		//parcourir les mains à ajouter
		for(Bid bid : listHandsAndBids) {
			//Comparer les mains existantes pour placer un élément
			insertBidInRanking(bid);
		}
	}
	
	private static void insertBidInRanking(Bid newBid) {
		listBidsRanked.add(newBid);
        Collections.sort(listBidsRanked);
    }
	
	
	public static int calcTotalWinnings() throws IllegalArgumentException, Exception {
		//Créer le classement
		rankAllBids();
		
		//Calculer les gains
		int resultWinnings = 0;
		int indexRank = 1;
		
		for(Bid bid : listBidsRanked) {
			resultWinnings += bid.getBidValue() * indexRank;
			
			indexRank++;
		}
		
		return resultWinnings;
	}
	
	public static void main(String[] args) throws Exception {
		convertInput();

		int resultV1 = calcTotalWinnings();
		System.out.println("Result V1 = " + resultV1);
	}

}
