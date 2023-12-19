package day7;

import java.util.LinkedList;

public class Hand implements Comparable<Hand> {

	private LinkedList<Card> cards;
	
	private HandType handType;
	
	public Hand() {
		this.cards = new LinkedList<Card>();
	}
	
	public Hand(LinkedList<Card> cards) {
		this.cards = cards;
	}

	public LinkedList<Card> getCards() {
		return cards;
	}

	public void addCard(Card card) {
		this.cards.add(card);
	}
	
	public Card getCard(int index) {
		return this.cards.get(index);
	}
	
	public HandType getHandType() throws IllegalArgumentException, Exception {
		this.generateHandType();
		
		return this.handType;
	}

	public void generateHandType() throws IllegalArgumentException, Exception {
		this.handType = HandType.determineHandType(this);
	}
	
	/**
	 * Renvoie -2 si erreur, -1 si hand1 < hand2, 0 si ==, 1 si hand1 > hand2
	 */
	@Override
	public int compareTo(Hand hand2) {
		int result = -2;
		
		result = compareByHandType(hand2);
		
		if(result == 0) {
			result = compareByCardValue(hand2);
		}
		
		return result;
	}
	
	private int compareByHandType(Hand hand2) {
		int result = -2;
		
		try {
			this.generateHandType();
			hand2.generateHandType();
			
			int valueHand1 = this.handType.getValue();
			int valueHand2 = hand2.getHandType().getValue();
			
			if (valueHand1 == valueHand2) {
				result = 0;
			} else if (valueHand1 > valueHand2) {
				result = 1;
			} else {
				result = -1;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	private int compareByCardValue(Hand hand2) {
		int result = -2;
		
		//La méthode de comparaison compareByHandType() a déjà testé que les tailles des mains soient = 5
		for(int indexCard = 0; indexCard < this.cards.size(); indexCard++) {
			result = this.getCard(indexCard).compareTo(hand2.getCard(indexCard));
			
			if(result != -2 && result != 0)
				break;
		}
		
		return result;
	}
	
	@Override
	public String toString() {
		String str = "Main ";
		str += this.handType != null ? "(type : " + this.handType + ") " : "";
		
		str += "- Composition : ";
		
		for(Card card : this.cards) {
			str += card.toString();
		}
		
		return str;
	}
	
	public static Hand constructHandFromInput(String line) throws IllegalArgumentException {
		if(line.length() != 5)
			throw new IllegalArgumentException("Taille de la main incorrecte : '" + line + "'");
		
		Hand handConstruct = new Hand();
		
		for(int indexValue = 0; indexValue < 5; indexValue++) {
			handConstruct.addCard(new Card(String.valueOf(line.charAt(indexValue))));
		}
			
		return handConstruct;
	}
	
}
