/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.co.gregs.kitomba.rovers;

import static org.hamcrest.CoreMatchers.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author greg
 */
public class MoveTest {

	public MoveTest() {
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
	 * Test of values method, of class Move.
	 */
	@Test
	public void testValues() {
		System.out.println("values");
		Move[] result = Move.values();
		Assert.assertThat(result.length, is(3));
		Assert.assertThat(result[0], is(Move.L));
		Assert.assertThat(result[1], is(Move.R));
		Assert.assertThat(result[2], is(Move.M));
	}

	/**
	 * Test of valueOf method, of class Move.
	 */
	@Test
	public void testValueOf() {
		System.out.println("valueOf");
		Assert.assertThat(Move.valueOf("L"), is(Move.L));
		Assert.assertThat(Move.valueOf("M"), is(Move.M));
		Assert.assertThat(Move.valueOf("R"), is(Move.R));
	}
	
	
	@Test
	public void testTurnLeft() throws MoveOutOfBoundsException, MoveWouldCollideWithAnotherRoverException {
		Rover instance = new Rover("RoverRover", 1, 2, Direction.E, 3, 4, "LRM");
		Move.L.move(instance, new Rover[]{});
		assertEquals(instance.getDirection(), Direction.N);
	}

	@Test
	public void testTurnRight() throws MoveOutOfBoundsException, MoveWouldCollideWithAnotherRoverException {
		Rover instance = new Rover("RoverRover", 1, 2, Direction.E, 3, 4, "LRM");
		Move.R.move(instance, new Rover[]{});
		assertEquals(instance.getDirection(), Direction.S);
	}

	@Test
	public void testMove() throws Exception {
		Rover instance = new Rover("RoverRover", 1, 2, Direction.E, 3, 4, "LRM");
		Move.M.move(instance, new Rover[]{});
		assertEquals(instance.getDirection(), Direction.E);
		assertEquals(instance.getX(), 2);
		assertEquals(instance.getY(), 2);
	}

}
