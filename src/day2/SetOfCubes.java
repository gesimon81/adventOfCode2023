package day2;

public class SetOfCubes {

	private int nbBlueCubes;
	private int nbRedCubes;
	private int nbGreenCubes;
	
	public SetOfCubes() {
		this.nbBlueCubes = 0;
		this.nbRedCubes = 0;
		this.nbGreenCubes = 0;
	}
	
	public SetOfCubes(int nbBlueCubes, int nbRedCubes, int nbGreenCubes) {
		this.nbBlueCubes = nbBlueCubes;
		this.nbRedCubes = nbRedCubes;
		this.nbGreenCubes = nbGreenCubes;
	}
	
	/**
	 * blue red green
	 */
	public boolean isSetOfCubesPossible(int limitBlueCubes, int limitRedCubes, int limitGreenCubes) {
		if(nbBlueCubes <= limitBlueCubes && nbRedCubes <= limitRedCubes && nbGreenCubes <= limitGreenCubes) {
			return true;
		} else {
			return false;
		}
	}
	
	public static int calcSetOfCubesPower(int nbBlueCubes, int nbRedCubes, int nbGreenCubes) {
		return nbBlueCubes * nbRedCubes * nbGreenCubes;
	}

	public int getNbBlueCubes() {
		return nbBlueCubes;
	}

	public void setNbBlueCubes(int nbBlueCubes) {
		this.nbBlueCubes = nbBlueCubes;
	}

	public int getNbRedCubes() {
		return nbRedCubes;
	}

	public void setNbRedCubes(int nbRedCubes) {
		this.nbRedCubes = nbRedCubes;
	}

	public int getNbGreenCubes() {
		return nbGreenCubes;
	}

	public void setNbGreenCubes(int nbGreenCubes) {
		this.nbGreenCubes = nbGreenCubes;
	}
	
}
