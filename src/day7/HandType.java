package day7;

import java.util.HashMap;

public enum HandType {
	FIVE_OF_A_KIND(7), 
	FOUR_OF_A_KIND(6),
	FULL_HOUSE(5),
	THREE_OF_A_KIND(4),
	TWO_PAIR(3),
	ONE_PAIR(2),
	HIGH_CARD(1);
	
	private final int value;
	
	HandType(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	public static HandType determineHandType(Hand hand) throws Exception, IllegalArgumentException {
		if(hand.getCards().size() <= 0 || hand.getCards().size() >= 6) {
			throw new IllegalArgumentException("Le paramètre donné ne correspond pas à une main : size = " + hand.getCards().size());
		}
		
		HashMap<Card, Integer> nbCardsOfAKind = new HashMap<Card, Integer>();
		
		//Déterminer le nombre d'exemplaire de chaque carte
		for(Card card : hand.getCards()) {
			if(!nbCardsOfAKind.containsKey(card))
				nbCardsOfAKind.put(card, 0);
			
			nbCardsOfAKind.put(card, nbCardsOfAKind.get(card) + 1);
		}
		
		
		//Déterminer le type de main
		if(nbCardsOfAKind.size() == 1) {
			//Five of a kind
			return FIVE_OF_A_KIND;
		} else if(nbCardsOfAKind.size() == 2) {
			//Four of a kind or Full house
			Integer[] coll = nbCardsOfAKind.values().toArray(new Integer[0]);
			if((coll[0] == 4 && coll[1] == 1) || (coll[0] == 1 && coll[1] == 4)) {
				//Four of a kind
				return FOUR_OF_A_KIND;
			} else if((coll[0] == 3 && coll[1] == 2) || (coll[0] == 2 && coll[1] == 3)) {
				//Full house
				return FULL_HOUSE;
			} else {
				throw new Exception("Main non reconnue : " + hand);
			}
		} else if(nbCardsOfAKind.size() == 3) {
			//Three of a kind or 2 Pair
			Integer[] coll = nbCardsOfAKind.values().toArray(new Integer[0]);
			if((coll[0] == 3 && coll[1] == 1 && coll[2] == 1) || (coll[0] == 1 && coll[1] == 3 && coll[2] == 1) || (coll[0] == 1 && coll[1] == 1 && coll[2] == 3)) {
				//Three of a kind
				return THREE_OF_A_KIND;
			} else 	if((coll[0] == 2 && coll[1] == 2 && coll[2] == 1) || (coll[0] == 2 && coll[1] == 1 && coll[2] == 2) || (coll[0] == 1 && coll[1] == 2 && coll[2] == 2)) {
				//2 pair
				return TWO_PAIR;
			} else {
				throw new Exception("Main non reconnue" + hand);
			}
		} else if(nbCardsOfAKind.size() == 4) {
			//One Pair
			return ONE_PAIR;
		} else if(nbCardsOfAKind.size() == 5) {
			//High card
			return HIGH_CARD;
		} else {
			throw new IllegalArgumentException("Le paramètre donné ne correspond pas à une main : size = " + hand.getCards().size());
		}
	}
}
