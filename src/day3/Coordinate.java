package day3;

import java.util.Objects;

public class Coordinate {
	private int coordX;
	
	private int coordY;
	
	public Coordinate(int coordX, int coordY) {
		this.coordX = coordX;
		this.coordY = coordY;
	}
	
	public int getCoordX() {
		return coordX;
	}


	public void setCoordX(int coordX) {
		this.coordX = coordX;
	}


	public int getCoordY() {
		return coordY;
	}


	public void setCoordY(int coordY) {
		this.coordY = coordY;
	}

	/**
	 * Détermine si deux coordonnées sont adjacentes
	 * @param coord1
	 * @param coord2
	 * @return
	 */
	public static boolean isAdjacent(Coordinate coord1, Coordinate coord2) {
		if(coord1.equals(coord2))  
			return true;
		
		Coordinate coordinateMock;
		
		//Tester les modifications sur x
		coordinateMock = new Coordinate(coord1.getCoordX() + 1, coord1.getCoordY());
		if(coordinateMock.equals(coord2))
			return true;
		
		coordinateMock = new Coordinate(coord1.getCoordX() - 1, coord1.getCoordY());
		if(coordinateMock.equals(coord2))
			return true;
		
		//Tester les modifications sur y
		coordinateMock = new Coordinate(coord1.getCoordX(), coord1.getCoordY() + 1);
		if(coordinateMock.equals(coord2))
			return true;
		
		coordinateMock = new Coordinate(coord1.getCoordX(), coord1.getCoordY() - 1);
		if(coordinateMock.equals(coord2))
			return true;
		
		//Tester les modifications sur x+y
		coordinateMock = new Coordinate(coord1.getCoordX() + 1, coord1.getCoordY() + 1);
		if(coordinateMock.equals(coord2))
			return true;
		
		coordinateMock = new Coordinate(coord1.getCoordX() + 1, coord1.getCoordY() - 1);
		if(coordinateMock.equals(coord2))
			return true;
		
		coordinateMock = new Coordinate(coord1.getCoordX() - 1, coord1.getCoordY() + 1);
		if(coordinateMock.equals(coord2))
			return true;
		
		coordinateMock = new Coordinate(coord1.getCoordX() - 1, coord1.getCoordY() - 1);
		if(coordinateMock.equals(coord2))
			return true;
		
		
		return false;
	}
	
	// Méthodes equals() et hashCode() pour permettre l'utilisation dans un ensemble (Set)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate coordToCompare = (Coordinate) o;
        return this.coordX == coordToCompare.getCoordX() && this.coordY == coordToCompare.getCoordY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.coordX, this.coordY);
    }

    @Override
    public String toString() {
        return "(" + this.coordX + "," + this.coordY + ")";
    }
}
