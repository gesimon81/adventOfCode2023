package day5;

public enum Category {
	SEED, SOIL, FERTILIZER, WATER, LIGHT, TEMPERATURE, HUMIDITY, LOCATION;
	
	/**
	 * Indique l'ordre des catégories en retournant la catégorie suivante
	 * @param categorySource
	 * @return
	 * @throws IllegalArgumentException
	 */
	public static Category getCategoryDestination(Category categorySource) throws IllegalArgumentException {
		Category categoryDestination;
		
		switch(categorySource) {
			case SEED:
				categoryDestination = SOIL;
				break;
			case SOIL:
				categoryDestination = FERTILIZER;
				break;
			case FERTILIZER:
				categoryDestination = WATER;
				break;
			case WATER:
				categoryDestination = LIGHT;
				break;
			case LIGHT:
				categoryDestination = TEMPERATURE;
				break;
			case TEMPERATURE:
				categoryDestination = HUMIDITY;
				break;
			case HUMIDITY:
				categoryDestination = LOCATION;
				break;
			case LOCATION:
				categoryDestination = null;
				break;
			default:
				throw new IllegalArgumentException("getCategoryDestination() la source donnée '" + categorySource + "'n'est pas une Catégorie");
		}
				
		return categoryDestination;
	}
	
	/**
	 * Indique l'ordre des catégories en retournant le nom de la table de conversion vers la catégorie suivante
	 * @param categorySource
	 * @return
	 * @throws IllegalArgumentException
	 */
	public static String getNameConversionMapFromCategorySource(Category categorySource) throws IllegalArgumentException {
		String nameConversionMap;
		
		switch(categorySource) {
			case SEED:
				nameConversionMap = "seed-to-soil";
				break;
			case SOIL:
				nameConversionMap = "soil-to-fertilizer";
				break;
			case FERTILIZER:
				nameConversionMap = "fertilizer-to-water";
				break;
			case WATER:
				nameConversionMap = "water-to-light";
				break;
			case LIGHT:
				nameConversionMap = "light-to-temperature";
				break;
			case TEMPERATURE:
				nameConversionMap = "temperature-to-humidity";
				break;
			case HUMIDITY:
				nameConversionMap = "humidity-to-location";
				break;
			case LOCATION:
				nameConversionMap = "";
				break;
			default:
				throw new IllegalArgumentException("getNameConversionMapFromCategorySource() la source donnée '" + categorySource + "'n'est pas une Catégorie");
		}
				
		return nameConversionMap;
	}
}
