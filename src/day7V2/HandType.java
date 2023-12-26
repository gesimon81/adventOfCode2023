package day7V2;

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
		
		if(nbCardsOfAKind.containsKey(new Card("J"))) {
			return determineHandTypeWithJokerAllCases(hand, nbCardsOfAKind);
		} else {
			return determineHandTypeWithoutJoker(hand, nbCardsOfAKind);
		}
		
	}
	
	private static HandType determineHandTypeWithoutJoker(Hand hand, HashMap<Card, Integer> nbCardsOfAKind) throws Exception, IllegalArgumentException {
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
	
	//traiter le cas du joker
	private static HandType determineHandTypeWithJoker(Hand hand, HashMap<Card, Integer> nbCardsOfAKind) throws Exception, IllegalArgumentException {
		/*
	 		Size = 3 et nbJ = 1 	5558J = 5888J 			=> THREE_OF_A_KIND 		=> FOUR_OF_A_KIND
									5588J 					=> TWO_PAIR				=> FULL_HOUSE
			Size = 3 et nbJ = 2 	558JJ = 588JJ 			=> ONE_PAIR				=> FOUR_OF_A_KIND
			Size = 3 et nbJ = 3 	58JJJ					=> HIGH_CARD			=> ONE_PAIR
	
			Size = 4 et nbJ = 1		558AJ = 588AJ = 58AAJ	=> ONE_PAIR 			=> THREE_OF_A_KIND
			Size = 4 et nbJ = 2		58AJJ					=> HIGH_CARD			=> THREE_OF_A_KIND
		 */
		
		//Déterminer le type de main
		if(nbCardsOfAKind.size() == 1 || nbCardsOfAKind.size() == 2) {
			//Five of a kind JJJJJ || 5JJJJ, 55JJJ, 555JJ, 5555J
			return FIVE_OF_A_KIND;
		} else if(nbCardsOfAKind.size() == 5) {
			//High card --> ONE_PAIR 4567J
			return ONE_PAIR;
		} else if(nbCardsOfAKind.size() == 3) {
			//Combien de joker (et donc combien de cartes non joker)
			int nbJoker = nbCardsOfAKind.get(new Card("J"));
			nbCardsOfAKind.remove(new Card("J"));
			
			if(nbJoker == 1) {
				//Combien de cartes non joker pour chaque carte
				Integer[] coll = nbCardsOfAKind.values().toArray(new Integer[0]);
				
				if((coll[0] == 3 && coll[1] == 1) || (coll[0] == 1 && coll[1] == 3)) { 
					return FOUR_OF_A_KIND;
				} else if(coll[0] == 2 && coll[1] == 2) {
					return FULL_HOUSE;
				} else {
					throw new Exception("Main non reconnue : " + hand);
				}
			} else if(nbJoker == 2) {
				return FOUR_OF_A_KIND;
			} else if(nbJoker == 3) {
				return ONE_PAIR;
			} else {
				throw new Exception("Main non reconnue : " + hand);
			}			
		} else if(nbCardsOfAKind.size() == 4) {
			//THREE_OF_A_KIND
			return THREE_OF_A_KIND;
		} else {
			throw new IllegalArgumentException("Le paramètre donné ne correspond pas à une main : size = " + hand.getCards().size());
		}
	}

	//traiter le cas du joker avec matrice excel
		private static HandType determineHandTypeWithJokerAllCases(Hand hand, HashMap<Card, Integer> nbCardsOfAKind) throws Exception, IllegalArgumentException {
			//Combien de cartes différentes
			int nbCardsValues = nbCardsOfAKind.size();
			
			//Combien de joker (et donc combien de cartes non joker)
			int nbJoker = nbCardsOfAKind.get(new Card("J"));
			nbCardsOfAKind.remove(new Card("J"));
			
			if(nbCardsValues == 1) {
				if(nbJoker == 5) {
					return FIVE_OF_A_KIND;
				} else {
					throw new Exception("Main non reconnue : " + hand);
				}
			} else if(nbCardsValues == 2) {
				if(nbJoker == 1 || nbJoker == 2 || nbJoker == 3 || nbJoker == 4) {
					return FIVE_OF_A_KIND;
				} else {
					throw new Exception("Main non reconnue : " + hand);
				}
			} else if(nbCardsValues == 3) {
				if(nbJoker == 1) {
					//Combien de cartes non joker pour chaque carte
					Integer[] coll = nbCardsOfAKind.values().toArray(new Integer[0]);
					
					if((coll[0] == 3 && coll[1] == 1) || (coll[0] == 1 && coll[1] == 3)) { 
						return FOUR_OF_A_KIND;
					} else if(coll[0] == 2 && coll[1] == 2) {
						return FULL_HOUSE;
					} else {
						throw new Exception("Main non reconnue : " + hand);
					}
				} else if(nbJoker == 2 || nbJoker == 3) {
					return FOUR_OF_A_KIND;
				} else {
					throw new Exception("Main non reconnue : " + hand);
				}
			} else if(nbCardsValues == 4) {
				if(nbJoker == 1 || nbJoker == 2) {
					return THREE_OF_A_KIND;
				} else {
					throw new Exception("Main non reconnue : " + hand);
				}
			} else if(nbCardsValues == 5) {
				if(nbJoker == 1) {
					return ONE_PAIR;
				} else {
					throw new Exception("Main non reconnue : " + hand);
				}
			} else {
				throw new IllegalArgumentException("Le paramètre donné ne correspond pas à une main : size = " + hand.getCards().size());
			}
			
			
		}
}
