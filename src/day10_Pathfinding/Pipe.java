package day10_Pathfinding;

public class Pipe {

	private Coordinate coordinate;
	
	private PipeType type;
	
	private Pipe firstPipe;
	
	private Pipe secondPipe;
	
	public Pipe(Coordinate coordinate, PipeType type) {
		this.coordinate = coordinate;
		
		this.type = type;
	}
	
	public Pipe(Coordinate coordinate, String pipeValue) {
		this.coordinate = coordinate;
		
		this.type = PipeType.getPipeTypeByString(pipeValue);
	}

	public Pipe getFirstPipe() {
		return firstPipe;
	}

	public void setFirstPipe(Pipe firstPipe) {
		this.firstPipe = firstPipe;
	}

	public Pipe getSecondPipe() {
		return secondPipe;
	}

	public void setSecondPipe(Pipe secondPipe) {
		this.secondPipe = secondPipe;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public PipeType getType() {
		return type;
	}
	
	public String toString() {
		return "{" + coordinate.toString() + " = " + PipeType.getStringByPipeType(type) + "}";
	}
	
}
