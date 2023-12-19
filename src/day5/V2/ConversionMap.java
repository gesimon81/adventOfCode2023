package day5.V2;

public class ConversionMap {

	private final Category categorySource;
	
	private final Category categoryDestination;
	
	/**
	 * Lignes de conversion
	 * {{ destination range start, destination range end, source range start, source range end, range length }, ... }
	 */
	private long[][] rangeLines;
	
	public ConversionMap(Category categorySource, Category categoryDestination) {
		this.categorySource = categorySource;
		this.categoryDestination = categoryDestination;
	}
	
	public long[][] getRangeLines() {
		return rangeLines;
	}

	public void setRangeLines(long[][] rangeLines) {
		this.rangeLines = rangeLines;
	}

	public Category getCategorySource() {
		return categorySource;
	}

	public Category getCategoryDestination() {
		return categoryDestination;
	}

	/**
	 * Convertit un nombre d'une catégorie source vers sa valeur dans la catégorie destination
	 * @param sourceNumber
	 * @return
	 */
	public long convertSourceToDestination(long sourceNumber) {
		//Déterminer à quelle intervalle le nombre appartient
		for(int indexRange = 0; indexRange < rangeLines.length; indexRange++) {
			if(sourceNumber >= rangeLines[indexRange][2] && sourceNumber <= rangeLines[indexRange][3]) {
				//Conversion
				long distanceFromRangeStart = sourceNumber - rangeLines[indexRange][2];
				
				return rangeLines[indexRange][0] + distanceFromRangeStart;
			}
		}
		
		//Si le nombre n'appartient à aucun intervalle de la table, il n'est pas modifié	
		return sourceNumber;
	}
}
