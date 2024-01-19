package day10_Pathfinding;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestsDay10 {

	private static HashMap<Coordinate, Pipe> mapAllPipes; 
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		mapAllPipes = new HashMap<Coordinate, Pipe>();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testStartingPipe_HorizontalPipe() {
		//1 S 2
		
		Pipe firstNextPipe = new Pipe(new Coordinate(0, 0), PipeType.BEND90_SE); 
		Pipe secondNextPipe = new Pipe(new Coordinate(0, 2), PipeType.HORIZONTAL_PIPE);
		
		Coordinate coordPipe = new Coordinate(0, 1);
		
		try {
			assertEquals(PipeType.HORIZONTAL_PIPE, MainDay10.determinePipeTypeByTwoNextPipes(coordPipe, firstNextPipe, secondNextPipe));
		} catch (Exception e) {
			fail("Exception");
		}
	}
	
	@Test
	void testStartingPipe_VerticalPipe() {
		//1 
		//S
		//2
		
		Pipe firstNextPipe = new Pipe(new Coordinate(0, 2), PipeType.BEND90_SE); 
		Pipe secondNextPipe = new Pipe(new Coordinate(2, 2), PipeType.HORIZONTAL_PIPE);
		
		Coordinate coordPipe = new Coordinate(1, 2);
		
		try {
			assertEquals(PipeType.VERTICAL_PIPE, MainDay10.determinePipeTypeByTwoNextPipes(coordPipe, firstNextPipe, secondNextPipe));
		} catch (Exception e) {
			fail("Exception");
		}
	}
	
	@Test
	void testStartingPipe_BEND90_NE() { //L
		//1 
		//S	2
		
		
		Pipe firstNextPipe = new Pipe(new Coordinate(0, 0), PipeType.BEND90_SE); 
		Pipe secondNextPipe = new Pipe(new Coordinate(1, 1), PipeType.HORIZONTAL_PIPE);
		
		Coordinate coordPipe = new Coordinate(1, 0);
		
		try {
			assertEquals(PipeType.BEND90_NE, MainDay10.determinePipeTypeByTwoNextPipes(coordPipe, firstNextPipe, secondNextPipe));
		} catch (Exception e) {
			fail("Exception");
		}
	}

}
