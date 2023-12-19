package day3;

import java.util.LinkedList;

public class SchematicElementGroup {
	/**
	 * Concaténation du nombre
	 */
	private String value;
	
	/**
	 * Elements composant le nombre
	 */
	private LinkedList<SchematicElementUnit> elementsUnit;
	

	public SchematicElementGroup() {
		this.value = "";
		this.elementsUnit = new LinkedList<SchematicElementUnit>();
	}
	
	public String getValue() {
		return value;
	}

	public LinkedList<SchematicElementUnit> getElementsUnit() {
		return elementsUnit;
	}
	
	public void addNumberElement(SchematicElementUnit element) throws IllegalArgumentException {
		if(element.getType() != SchematicElementType.NUMBER)
			throw new IllegalArgumentException("L'élément a ajouté au groupe n'est pas un nombre");
		
		this.value = this.value.concat(element.getValue());
		this.elementsUnit.add(element);
	}
	
	/**
	 * Est-ce que le groupe est adjacent à une unité du schéma
	 * @param coordToCompare
	 * @return
	 */
	public boolean isAdjacentToUnit(Coordinate coordToCompare) {
		boolean isAdjacent = false;
		
		for(SchematicElementUnit elementUnit : this.elementsUnit) {
			if(Coordinate.isAdjacent(elementUnit.getCoordinate(), coordToCompare)) {
				isAdjacent = true;
				break;
			}
		}
		
		return isAdjacent;
	}

}
