package day7V2;

public class Bid implements Comparable<Bid> {

	private int bidValue;
	
	private Hand hand;
	
	public Bid(Hand hand, int bidValue) {
		this.bidValue = bidValue;
		
		this.hand = hand;
	}

	public int getBidValue() {
		return bidValue;
	}


	public Hand getHand() {
		return hand;
	}

	/**
	 * Renvoie -2 si erreur, -1 si hand1 < hand2, 0 si ==, 1 si hand1 > hand2
	 */
	@Override
	public int compareTo(Bid bid2) {
		return this.hand.compareTo(bid2.getHand());
	}
	
	@Override
	public String toString() {
		return "Bid : " + this.hand + " | " + this.bidValue;
	}
}
