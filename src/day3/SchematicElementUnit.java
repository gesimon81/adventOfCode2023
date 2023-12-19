package day3;

public class SchematicElementUnit {
	
	private SchematicElementType type;
	
	private Coordinate coordinate;
	
	private String value;
	
	public SchematicElementUnit() {
		// TODO Auto-generated constructor stub
	}
	
	public SchematicElementUnit(SchematicElementType type, Coordinate coordinate, String value) {
		this.type = type;
		this.coordinate = coordinate;
		this.value = value;
	}

	/**
	 * Est-ce que l'unité est adjacente à une autre unité du schéma
	 * @param coordToCompare
	 * @return
	 */
	public boolean isAdjacentToUnit(Coordinate coordToCompare) {
		return Coordinate.isAdjacent(this.coordinate, coordToCompare);
	}
	
	/**
	 * Teste si l'élément a le symbole de gear '*'
	 * ! Ne teste pas si l'élément est un gear (2 nombres adjacents)
	 * @return
	 */
	public boolean isAGearSymbol() {
		return this.value.contentEquals("*");
	}
	
	public SchematicElementType getType() {
		return type;
	}

	public void setType(SchematicElementType type) {
		this.type = type;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "Unit [" + this.type + "] aux coordonnées " + this.coordinate + " = " + this.value;
	}
}
