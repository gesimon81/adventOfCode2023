package day7;

import java.util.Objects;

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
	
	@Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        
        Card otherCard = (Card) obj;
        return value == otherCard.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
