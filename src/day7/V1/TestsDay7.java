package day7.V1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestsDay7 {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCard_OneCardValue() {
		Card card = new Card("5");
		assertEquals(5, card.getValue().getValue());
		card = new Card("A");
		assertEquals(14, card.getValue().getValue());
	}
	
	@Test
	void testCard_OneCardValueImpossible() {
		try {
			Card card = new Card("1");
			fail("Une exception de type 'IllegalArgumentException' aurait du être levée");
		} catch(Exception e) {
			
		}
		
	}
	
	@Test
	void testCard_Compare2CardsValue_Same() {
		Card card1 = new Card("T");
		Card card2 = new Card("T");
		
		assertEquals(0, card1.compareTo(card2));
	}
	
	@Test
	void testCard_Compare2CardsValue_Inferior() {
		Card card1 = new Card("5");
		Card card2 = new Card("T");
		
		assertEquals(-1, card1.compareTo(card2));
	}
	
	@Test
	void testCard_Compare2CardsValue_Superior() {
		Card card1 = new Card("T");
		Card card2 = new Card("7");
		
		assertEquals(1, card1.compareTo(card2));
	}

	
	//Tester le type Hand
	
	@Test
	void testHand_EmptyHand() {
		Hand hand = new Hand();

		assertTrue(hand.getCards().isEmpty());
	}
	
	@Test
	void testHand_HandConstructor() {
		Hand hand = Hand.constructHandFromInput("AAAT5");

		assertEquals(5, hand.getCards().size());
	}
	
	@Test
	void testHand_HandConstructor_ErrorNbCards() {
		try {
			Hand hand = Hand.constructHandFromInput("AA5");
			fail("Une exception de type 'IllegalArgumentException' aurait du être levée");
		} catch(Exception e) {
			
		}
		
		try {
			Hand hand = Hand.constructHandFromInput("AA5444444");
			fail("Une exception de type 'IllegalArgumentException' aurait du être levée");
		} catch(Exception e) {
			
		}
	}
	
	@Test
	void testHand_HandConstructor_ErrorCardsValue() {
		try {
			Hand hand = Hand.constructHandFromInput("AA5TV");
			fail("Une exception de type 'IllegalArgumentException' aurait du être levée");
		} catch(Exception e) {
			
		}
	}
	
	//Tester les types de mains	
	@Test
	void testHandType_FiveOfAKind() {
		try {
			Hand hand = Hand.constructHandFromInput("QQQQQ");
			
			assertEquals(HandType.FIVE_OF_A_KIND, hand.getHandType());
		} catch(Exception e) {
			fail("Une exception a été levée");
		}
	}
	
	@Test
	void testHandType_FourOfAKind() {
		try {
			Hand hand = Hand.constructHandFromInput("QQ3QQ");
			
			assertEquals(HandType.FOUR_OF_A_KIND, hand.getHandType());
		} catch(Exception e) {
			fail("Une exception a été levée");
		}
	}
	
	@Test
	void testHandType_FullHouse() {
		try {
			Hand hand = Hand.constructHandFromInput("QQ3Q3");
			
			assertEquals(HandType.FULL_HOUSE, hand.getHandType());
		} catch(Exception e) {
			fail("Une exception a été levée");
		}
	}
	
	@Test
	void testHandType_ThreeOfAKind() {
		try {
			Hand hand = Hand.constructHandFromInput("QQ3Q8");
			
			assertEquals(HandType.THREE_OF_A_KIND, hand.getHandType());
		} catch(Exception e) {
			fail("Une exception a été levée");
		}
	}
	
	@Test
	void testHandType_TwoPair() {
		try {
			Hand hand = Hand.constructHandFromInput("Q53Q3");
			
			assertEquals(HandType.TWO_PAIR, hand.getHandType());
		} catch(Exception e) {
			fail("Une exception a été levée");
		}
	}
	
	@Test
	void testHandType_OnePair() {
		try {
			Hand hand = Hand.constructHandFromInput("QQ36T");
			
			assertEquals(HandType.ONE_PAIR, hand.getHandType());
		} catch(Exception e) {
			fail("Une exception a été levée");
		}
	}
	
	@Test
	void testHandType_HighCard() {
		try {
			Hand hand = Hand.constructHandFromInput("QT3J2");
			
			assertEquals(HandType.HIGH_CARD, hand.getHandType());
		} catch(Exception e) {
			fail("Une exception a été levée");
		}
	}
}
