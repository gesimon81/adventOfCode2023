package day7.V1;

public enum CardValue {
	A(14),
    K(13),
    Q(12),
    J(11),
    T(10),
    _9(9),
    _8(8),
    _7(7),
    _6(6),
    _5(5),
    _4(4),
    _3(3),
    _2(2);

    private final int value;

    CardValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    
    public static CardValue getCardValueByString(String cardValueStr) throws IllegalArgumentException {
    	CardValue cardValue;
    	
    	switch(cardValueStr) {
    		case "A":
    			cardValue = A;
    			break;
    		case "K":
    			cardValue = K;
    			break;
    		case "Q":
    			cardValue = Q;
    			break;
    		case "J":
    			cardValue = J;
    			break;
    		case "T":
    			cardValue = T;
    			break;
    		case "9":
    			cardValue = _9;
    			break;
    		case "8":
    			cardValue = _8;
    			break;
    		case "7":
    			cardValue = _7;
    			break;
    		case "6":
    			cardValue = _6;
    			break;
    		case "5":
    			cardValue = _5;
    			break;
    		case "4":
    			cardValue = _4;
    			break;
    		case "3":
    			cardValue = _3;
    			break;
    		case "2":
    			cardValue = _2;
    			break;
    		default:
    			throw new IllegalArgumentException("La valeur saisie ne correspond pas à la valeur d'une carte");
    	}
    	
    	return cardValue;
    }
    
    @Override 
    public String toString() {
    	String str = "";
    	
    	switch(this.value) {
    		case 14:
    			str = "A";
    			break;
    		case 13:
    			str = "K";
    			break;
    		case 12:
    			str = "A";
    			break;
    		case 11:
    			str = "J";
    			break;
    		case 10:
    			str = "T";
    			break;
    		case 9:
    			str = "9";
    			break;
    		case 8:
    			str = "8";
    			break;
    		case 7:
    			str = "7";
    			break;
    		case 6:
    			str = "6";
    			break;
    		case 5:
    			str = "5";
    			break;
    		case 4:
    			str = "4";
    			break;
    		case 3:
    			str = "3";
    			break;
    		case 2:
    			str = "2";
    			break;
    		default:
    			throw new IllegalArgumentException("La valeur saisie ne correspond pas à la valeur d'une carte");
    	}
    	
    	return str;
    }
}