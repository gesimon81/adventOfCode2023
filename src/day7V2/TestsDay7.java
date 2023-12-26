package day7V2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;

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
		Card card1 = new Card("J");
		Card card2 = new Card("2");
		
		assertEquals(-1, card1.compareTo(card2));
	}
	
	@Test
	void testCard_Compare2CardsValue_Superior() {
		Card card1 = new Card("T");
		Card card2 = new Card("J");
		
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
			Hand hand = Hand.constructHandFromInput("QT382");
			
			assertEquals(HandType.HIGH_CARD, hand.getHandType());
		} catch(Exception e) {
			fail("Une exception a été levée");
		}
	}
	
	//Tester les types de mains	avec joker
		@Test
		void testHandType_FiveOfAKind_Joker() {
			try {
				Hand hand = Hand.constructHandFromInput("QQQQJ");
				assertEquals(HandType.FIVE_OF_A_KIND, hand.getHandType());
				
				hand = Hand.constructHandFromInput("QQQJJ");				
				assertEquals(HandType.FIVE_OF_A_KIND, hand.getHandType());
				
				hand = Hand.constructHandFromInput("JQQJJ");				
				assertEquals(HandType.FIVE_OF_A_KIND, hand.getHandType());
				
				hand = Hand.constructHandFromInput("QJJJJ");				
				assertEquals(HandType.FIVE_OF_A_KIND, hand.getHandType());
			} catch(Exception e) {
				fail("Une exception a été levée");
			}
		}
		
		@Test
		void testHandType_FourOfAKind_Joker() {
			try {
				Hand hand = Hand.constructHandFromInput("QQ3JQ");				
				assertEquals(HandType.FOUR_OF_A_KIND, hand.getHandType());
				
				hand = Hand.constructHandFromInput("JQ3JQ");				
				assertEquals(HandType.FOUR_OF_A_KIND, hand.getHandType());
			} catch(Exception e) {
				fail("Une exception a été levée");
			}
		}
		
		@Test
		void testHandType_FullHouse_Joker() {
			try {
				Hand hand = Hand.constructHandFromInput("QQ3J3");
				
				assertEquals(HandType.FULL_HOUSE, hand.getHandType());
			} catch(Exception e) {
				fail("Une exception a été levée");
			}
		}
		
		@Test
		void testHandType_ThreeOfAKind_Joker_1Joker() {
			try {
				Hand hand = Hand.constructHandFromInput("558AJ");
				
				assertEquals(HandType.THREE_OF_A_KIND, hand.getHandType());
			} catch(Exception e) {
				fail("Une exception a été levée : " + e);
			}
		}
		
		@Test
		void testHandType_ThreeOfAKind_Joker_2Joker() {
			try {
				Hand hand = Hand.constructHandFromInput("58AJJ");
				
				assertEquals(HandType.THREE_OF_A_KIND, hand.getHandType());
			} catch(Exception e) {
				fail("Une exception a été levée : " + e);
			}
		}
		
		@Test
		void testHandType_OnePair_Joker() {
			try {
				Hand hand = Hand.constructHandFromInput("4567J");
				
				assertEquals(HandType.ONE_PAIR, hand.getHandType());
				
				
			} catch(Exception e) {
				fail("Une exception a été levée");
			}
		}
		
		//Fix JJ5J6
		@Test
		void testHandType_FixJoker() {
			try {
				Hand hand = Hand.constructHandFromInput("JJ5J6");
				
				assertEquals(HandType.FOUR_OF_A_KIND, hand.getHandType());
				
				
			} catch(Exception e) {
				fail("Une exception a été levée");
			}
		}
		
		//Comparer les mains
		
		@Test
		void testCard_Compare2HandsValue_Inferior() {
			Hand hand1 = Hand.constructHandFromInput("J3375");
			Hand hand2 = Hand.constructHandFromInput("23337");
			
			assertEquals(-1, hand1.compareTo(hand2));
		}
		
		@Test
		void testCard_Compare2HandsValue_Fix() {
			Hand hand1 = Hand.constructHandFromInput("TTJTT");
			Hand hand2 = Hand.constructHandFromInput("KKJKK");
			
			assertEquals(-1, hand1.compareTo(hand2));
		}
		
		@Test
		void testCard_Compare2HandsValue_Fix_CollectionsSort() {
			
			Hand hand1 = Hand.constructHandFromInput("AAJAA"); //#3
			Hand hand2 = Hand.constructHandFromInput("KKJKK"); //#1
			Hand hand3 = Hand.constructHandFromInput("AJJAJ"); //#2
			/*
			Hand hand1 = Hand.constructHandFromInput("934K5"); //#2
			Hand hand3 = Hand.constructHandFromInput("8K539"); //#1
			Hand hand2 = Hand.constructHandFromInput("8AKA6"); //#3
			*/
			ArrayList<Hand> listHands = new ArrayList<Hand>();
			listHands.add(hand1);
			listHands.add(hand2);
			listHands.add(hand3);
			
			Collections.sort(listHands);
			
			// Vérifiez l'ordre des mains après le tri
		    assertEquals(hand2, listHands.get(0));  // Première main après le tri
		    assertEquals(hand3, listHands.get(1));  // Deuxième main après le tri
		    assertEquals(hand1, listHands.get(2));  // Troisième main après le tri

		    
		    System.out.println(listHands);
		}
		
}
