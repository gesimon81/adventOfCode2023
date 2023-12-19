package day3;

import java.util.regex.Pattern;

public enum SchematicElementType {
	NUMBER, SYMBOL, DOT;


	/**
	 * Détermine le type correspondant à un element du tableau
	 * @param element: element dont le type doit être déterminé
	 * @return le type correspondant (NUMBER, SYMBOL, DOT)
	 * @throws IllegalArgumentException si l'élément ne correspond pas à un type
	 */
	public static SchematicElementType determineTypeOfElement(String element) throws IllegalArgumentException {
		if(isDigit(element)) {
			return NUMBER;
		} else if(isSymbol(element)) {
			return SYMBOL;
		} else if(element.contentEquals(".")) {
			return DOT;
		} else {
			throw new IllegalArgumentException("L'élément '" + element + "' ne correspond pas à un type");
		}
	}
	
	/**
	 * teste si l'élément est un nombre
	 * @param element: élement du tableau à tester
	 * @return true si element est un nombre
	 */
	private static boolean isDigit(String element) {
        Character c = element.charAt(0);
		return Character.isDigit(c);
    }

	/**
	 * teste si l'élément est un symbole ($, /, *, +,=,@,%,&,#,-)
	 * @param element: élement du tableau à tester
	 * @return true si element est un symbole
	 */
    private static boolean isSymbol(String element) {
        // Définir le motif des symboles
        Pattern symbolPattern = Pattern.compile("[/$*+=@%&#-]");
        return symbolPattern.matcher(element).matches();
    }
}
