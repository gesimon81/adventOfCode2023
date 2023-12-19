package day7;

public class Card implements Comparable<Card> {

	private CardValue value;
	
	public Card(CardValue cardValue) {
		this.value = cardValue;
	}
	
	public Card(String cardValue) {
		this.value = CardValue.getCardValueByString(cardValue);
	}

	public CardValue getValue() {
		return value;
	}

	@Override
	public int compareTo(Card card2) {
		if (this.value.getValue() == card2.getValue().getValue()) return 0;

        if (this.value.getValue() > card2.getValue().getValue()) return 1;

        return -1; 
	}
	
	@Override
	public String toString() {
		return this.value.toString();
	}
}
