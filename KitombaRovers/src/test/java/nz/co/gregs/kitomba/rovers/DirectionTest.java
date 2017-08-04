/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.co.gregs.kitomba.rovers;

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
public class DirectionTest {

	public DirectionTest() {
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
	 * Test of left method, of class Direction.
	 */
	@Test
	public void testLeft() {
		Direction[][] tests = new Direction[][]{
			new Direction[]{Direction.N, Direction.W},
			new Direction[]{Direction.W, Direction.S},
			new Direction[]{Direction.S, Direction.E},
			new Direction[]{Direction.E, Direction.N},};
		for (Direction[] test : tests) {
			Direction instance = test[0];
			Direction expResult = test[1];
			Direction result = instance.left();
			assertEquals(expResult, result);
		}
	}

	/**
	 * Test of right method, of class Direction.
	 */
	@Test
	public void testRight() {
		Direction[][] tests = new Direction[][]{
			new Direction[]{Direction.N, Direction.E},
			new Direction[]{Direction.W, Direction.N},
			new Direction[]{Direction.S, Direction.W},
			new Direction[]{Direction.E, Direction.S},};
		for (Direction[] test : tests) {
			Direction instance = test[0];
			Direction expResult = test[1];
			Direction result = instance.right();
			assertEquals(expResult, result);
		}
	}

	/**
	 * Test of parseDirection method, of class Direction.
	 */
	@Test
	public void testParseDirection() throws Exception {
		Object[][] tests = new Object[][]{
			new Object[]{"E", Direction.E},
			new Object[]{"N", Direction.N},
			new Object[]{"W", Direction.W},
			new Object[]{"S", Direction.S},};
		for (Object[] test : tests) {
			String instance = (String)test[0];
			Direction expResult = (Direction) test[1];
			Direction result = Direction.parseDirection(instance);
			assertEquals(expResult, result);
		}
	}

}
