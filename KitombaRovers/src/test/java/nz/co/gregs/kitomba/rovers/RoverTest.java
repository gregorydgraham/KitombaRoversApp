/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.co.gregs.kitomba.rovers;

import static org.hamcrest.CoreMatchers.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author greg
 */
public class RoverTest {

	public RoverTest() {
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

	/**
	 * Test of getName method, of class Rover.
	 */
	@Test
	public void testGetName() {
		Rover instance = new Rover("RoverRover", 1, 2, Direction.E, 3, 4, "LRM");
		String expResult = "RoverRover";
		String result = instance.getName();
		assertEquals(expResult, result);
	}

	/**
	 * Test of getX method, of class Rover.
	 */
	@Test
	public void testGetX() {
		Rover instance = new Rover("RoverRover", 1, 2, Direction.E, 3, 4, "LRM");
		int expResult = 1;
		int result = instance.getX();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setX method, of class Rover.
	 */
	@Test
	public void testSetX() {
		int x = 0;
		Rover instance = new Rover("RoverRover", 1, 2, Direction.E, 3, 4, "LRM");
		instance.setX(x);
		int expResult = x;
		int result = instance.getX();
		assertEquals(expResult, result);
	}

	/**
	 * Test of getY method, of class Rover.
	 */
	@Test
	public void testGetY() {
		Rover instance = new Rover("RoverRover", 1, 2, Direction.E, 3, 4, "LRM");
		int expResult = 2;
		int result = instance.getY();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setY method, of class Rover.
	 */
	@Test
	public void testSetY() {
		int y = 0;
		Rover instance = new Rover("RoverRover", 1, 2, Direction.E, 3, 4, "LRM");
		instance.setY(y);
		int expResult = y;
		int result = instance.getY();
		assertEquals(expResult, result);
	}

	/**
	 * Test of getDirection method, of class Rover.
	 */
	@Test
	public void testGetDirection() {
		Rover instance = new Rover("RoverRover", 1, 2, Direction.E, 3, 4, "LRM");
		Direction expResult = Direction.E;
		Direction result = instance.getDirection();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setDirection method, of class Rover.
	 */
	@Test
	public void testSetFacing() {
		Direction facing = Direction.N;
		Rover instance = new Rover("RoverRover", 1, 2, Direction.E, 3, 4, "LRM");
		instance.setDirection(facing);
		Direction expResult = facing;
		Direction result = instance.getDirection();
		assertEquals(expResult, result);
	}

	/**
	 * Test of getMinX method, of class Rover.
	 */
	@Test
	public void testGetMinX() {
		Rover instance = new Rover("RoverRover", 1, 2, Direction.E, 3, 4, "LRM");
		int expResult = 0;
		int result = instance.getMinX();
		assertEquals(expResult, result);
	}

	/**
	 * Test of getMinY method, of class Rover.
	 */
	@Test
	public void testGetMinY() {
		Rover instance = new Rover("RoverRover", 1, 2, Direction.E, 3, 4, "LRM");
		int expResult = 0;
		int result = instance.getMinY();
		assertEquals(expResult, result);
	}

	/**
	 * Test of getMaxX method, of class Rover.
	 */
	@Test
	public void testGetMaxX() {
		Rover instance = new Rover("RoverRover", 1, 2, Direction.E, 3, 4, "LRM");
		int expResult = 3;
		int result = instance.getMaxX();
		assertEquals(expResult, result);
	}

	/**
	 * Test of getMaxY method, of class Rover.
	 */
	@Test
	public void testGetMaxY() {
		Rover instance = new Rover("RoverRover", 1, 2, Direction.E, 3, 4, "LRM");
		int expResult = 4;
		int result = instance.getMaxY();
		assertEquals(expResult, result);
	}

	/**
	 * Test of executeMoves method, of class Rover.
	 */
	@Test
	public void testExecuteMoves() throws Exception {
		Object[][] tests = new Object[][]{
			new Object[]{new Rover("RoverRover", 1, 2, Direction.E, 3, 4, "LRM"), null, "2 2 E"},
			new Object[]{new Rover("RoverRover", 1, 2, Direction.E, 3, 4, "LM"), null, "1 3 N"},
			new Object[]{new Rover("RoverRover", 1, 2, Direction.E, 3, 4, "RM"), null, "1 1 S"},
			new Object[]{new Rover("RoverRover", 1, 2, Direction.E, 3, 4, "RML"), null, "1 1 E"},
			new Object[]{new Rover("RoverRover", 1, 2, Direction.E, 3, 4, "RMLM"), null, "2 1 E"},
			new Object[]{new Rover("RoverRover", 1, 2, Direction.E, 3, 4, "RMLMRRMM"), null, "0 1 W"}
		};
		for (Object[] test : tests) {
			Rover instance = (Rover) test[0];
			Rover[] otherRovers = (Rover[]) test[1];
			String expected = (String) test[2];
			String executeMoves = instance.executeMoves(otherRovers);
			assertEquals(expected, executeMoves);
		}
	}

	/**
	 * Test of turnLeft method, of class Rover.
	 */
	@Test
	public void testTurnLeft() {
		Rover instance = new Rover("RoverRover", 1, 2, Direction.E, 3, 4, "LRM");
		instance.turnLeft();
		assertEquals(instance.getDirection(), Direction.N);
	}

	/**
	 * Test of turnRight method, of class Rover.
	 */
	@Test
	public void testTurnRight() {
		Rover instance = new Rover("RoverRover", 1, 2, Direction.E, 3, 4, "LRM");
		instance.turnRight();
		assertEquals(instance.getDirection(), Direction.S);
	}

	/**
	 * Test of moveForward method, of class Rover.
	 */
	@Test
	public void testMove() throws Exception {
		Rover[] otherRovers = null;
		Rover instance = new Rover("RoverRover", 1, 2, Direction.E, 3, 4, "LRM");
		instance.moveForward(otherRovers);
		assertEquals(instance.getDirection(), Direction.E);
		assertEquals(instance.getX(), 2);
		assertEquals(instance.getY(), 2);
	}

	/**
	 * Test of checkMove method, of class Rover.
	 *
	 * @throws nz.co.gregs.kitomba.rovers.MoveOutOfBoundsException
	 * @throws
	 * nz.co.gregs.kitomba.rovers.MoveWouldCollideWithAnotherRoverException
	 */
	@Test
	public void testCheckMove() throws MoveOutOfBoundsException, MoveWouldCollideWithAnotherRoverException {
		int newX = 2;
		int newY = 2;
		Rover instance = new Rover("RoverRover", 1, 2, Direction.E, 3, 4, "LRM");
		Rover[] otherRovers = new Rover[]{new Rover("RoverZero", 0, 0, Direction.E, 3, 4, "LRM")};
		boolean result = instance.checkMove(newX, newY, otherRovers);
		assertTrue("Expected the move to be ok but wasn't", result);
	}

	@Test(expected = MoveWouldCollideWithAnotherRoverException.class)
	public void testCheckMoveFailsWithCollision() throws MoveOutOfBoundsException, MoveWouldCollideWithAnotherRoverException {
		int newX = 0;
		int newY = 0;
		Rover instance = new Rover("RoverRover", 1, 2, Direction.E, 3, 4, "LRM");
		Rover[] otherRovers = new Rover[]{new Rover("RoverZero", 0, 0, Direction.E, 3, 4, "LRM")};
		boolean result = instance.checkMove(newX, newY, otherRovers);
		assertTrue("Expected the move to be ok but wasn't", result);
	}

	@Test()
	public void testExecuteMovesFailsWithCollisionPreservesLocationAndMoves() throws MoveOutOfBoundsException {
		Rover instance = new Rover("RoverRover", 1, 2, Direction.E, 3, 4, "RRMLMMLMM");
		Rover[] otherRovers = new Rover[]{new Rover("RoverZero", 0, 0, Direction.E, 3, 4, "LRM")};
		try {
			String result = instance.executeMoves(otherRovers);
			fail("Should have thrown a collision exception, instead returned: "+result);
		} catch (MoveWouldCollideWithAnotherRoverException collision) {
			assertThat(collision, isA(MoveWouldCollideWithAnotherRoverException.class));
			assertThat(instance.getX(), is(0));
			assertThat(instance.getY(), is(1));
			assertThat(instance.getMoves(), is("MLMM"));
		}
	}

	@Test(expected = MoveOutOfBoundsException.class)
	public void testCheckMoveFailsWithOutOfBounds() throws MoveOutOfBoundsException, MoveWouldCollideWithAnotherRoverException {
		int newX = 5;
		int newY = 0;
		Rover instance = new Rover("RoverRover", 1, 2, Direction.E, 3, 4, "LRM");
		Rover[] otherRovers = new Rover[]{new Rover("RoverZero", 0, 0, Direction.E, 3, 4, "LRM")};
		boolean result = instance.checkMove(newX, newY, otherRovers);
		assertTrue("Expected the move to be ok but wasn't", result);
	}

	@Test(expected = MoveOutOfBoundsException.class)
	public void testCheckMoveFailsWithOutOfBoundsWithNegativeDestination() throws MoveOutOfBoundsException, MoveWouldCollideWithAnotherRoverException {
		int newX = 2;
		int newY = -1;
		Rover instance = new Rover("RoverRover", 1, 2, Direction.E, 3, 4, "LRM");
		Rover[] otherRovers = new Rover[]{new Rover("RoverZero", 0, 0, Direction.E, 3, 4, "LRM")};
		boolean result = instance.checkMove(newX, newY, otherRovers);
		assertTrue("Expected the move to be ok but wasn't", result);
	}

	/**
	 * Test of setLocation method, of class Rover.
	 */
	@Test
	public void testSetLocation() {
		int newX = 0;
		int newY = 1;
		Rover instance = new Rover("RoverRover", 1, 2, Direction.E, 3, 4, "LRM");
		instance.setLocation(newX, newY);
		assertThat(instance.getX(), is(0));
		assertThat(instance.getY(), is(1));
	}

	/**
	 * Test of setDirection method, of class Rover.
	 */
	@Test
	public void testSetDirection() {
		Direction facing = Direction.W;
		Rover instance = new Rover("RoverRover", 1, 2, Direction.E, 3, 4, "LRM");
		instance.setDirection(facing);
		assertThat(instance.getDirection(), is(Direction.W));
	}

}
