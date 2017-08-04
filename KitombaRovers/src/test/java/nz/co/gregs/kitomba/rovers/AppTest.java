/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.co.gregs.kitomba.rovers;

import java.text.ParseException;
import java.util.Scanner;
import static org.hamcrest.CoreMatchers.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author greg
 */
public class AppTest {

	public AppTest() {
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
	 * Test of main method, of class App.
	 */
	@Test
	public void testMain() throws Exception {
		String[] args = new String[]{"TEST"};
		App.main(args);
		// Should run the TEST input with no errors
	}

	/**
	 * Test of readBounds method, of class App.
	 */
	@Test
	public void testReadBoundsAcceptsTestInput() throws Exception {
		Scanner scanner = new Scanner("5 5");
		App instance = new App();
		instance.readBounds(scanner);
		Assert.assertThat(instance.maxX, is(5));
		Assert.assertThat(instance.maxY, is(5));
	}

	@Test
	public void testReadBoundsSetsXAndYCorrectly() throws Exception {
		Scanner scanner = new Scanner("9 10");
		App instance = new App();
		instance.readBounds(scanner);
		Assert.assertThat(instance.maxX, is(9));
		Assert.assertThat(instance.maxY, is(10));
	}

	@Test(expected = IncorrectInputException.class)
	public void testReadBoundsRefusesIncorrectInput() throws Exception {
		Scanner scanner = new Scanner("five five");
		App instance = new App();
		instance.readBounds(scanner);
	}

	@Test(expected = NegativeBoundException.class)
	public void testReadBoundsRefusesNegativeX() throws Exception {
		Scanner scanner = new Scanner("-5 5");
		App instance = new App();
		instance.readBounds(scanner);
	}

	@Test(expected = NegativeBoundException.class)
	public void testReadBoundsRefusesNegativeY() throws Exception {
		Scanner scanner = new Scanner("-5 5");
		App instance = new App();
		instance.readBounds(scanner);
	}

	/**
	 * Test of readRover method, of class App.
	 *
	 * @throws nz.co.gregs.kitomba.rovers.IncorrectInputException
	 * @throws java.text.ParseException
	 */
	@Test
	public void testReadRover() throws IncorrectInputException, ParseException {
		App instance = new App();
		instance.maxX = 5;
		instance.maxY = 5;
		String roverName = "Rover-1";
		Object[][] tests = new Object[][]{
			new Object[]{"1 2 N LMLMLMLMM", new Rover("Rover-1", 1, 2, Direction.N, 5, 5, "LMLMLMLMM")},
			new Object[]{"3 3 E MMRMMRMRRM", new Rover("Rover-1", 3, 3, Direction.E, 5, 5, "MMRMMRMRRM")},
			new Object[]{"1 2 N\nLMLMLMLMM", new Rover("Rover-1", 1, 2, Direction.N, 5, 5, "LMLMLMLMM")},
			new Object[]{"3 3 E\nMMRMMRMRRM", new Rover("Rover-1", 3, 3, Direction.E, 5, 5, "MMRMMRMRRM")}
		};
		for (Object[] test : tests) {
			Scanner scanner = new Scanner((String) test[0]);
			Rover expected = (Rover) test[1];
			Rover actual = instance.readRover(scanner, roverName);
			Assert.assertTrue(expected.equals(actual));
		}
	}

}
