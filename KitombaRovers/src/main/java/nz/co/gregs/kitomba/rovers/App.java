package nz.co.gregs.kitomba.rovers;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * The Application class for this program.
 *
 * <p>
 * This class supplies the required main method for running the program from the
 * command line.</p>
 *
 * <p>
 * Methods for reading and parsing the input lines are included in this
 * class.</p>
 *
 * @author Gregory Graham
 */
public class App {

	private static final List<Rover> rovers = new ArrayList<>();

	public static void main(String[] args) throws IncorrectInputException, MoveOutOfBoundsException, MoveWouldCollideWithAnotherRoverException, ParseException, NegativeBoundException {

		Scanner scanner = new Scanner(System.in);
		if (args.length > 0 && "TEST".equals(args[0])) {
			scanner = new Scanner(
					"5 5\n"
					+ "1 2 N LMLMLMLMM\n"
					+ "3 3 E MMRMMRMRRM\n\n"
			);
		}

		App app = new App();
		app.readBounds(scanner);
		for (int index = 1; index > 0; index++) {
			Rover rover = app.readRover(scanner, "Rover-" + index);
			if (rover != null) {
				rovers.add(rover);
			} else {
				index = -1;
			}
		}
		System.out.println("MOVE RESULTS");
		for (Rover rover : rovers) {
			List<Rover> otherRovers = new ArrayList<>();
			otherRovers.addAll(rovers);
			otherRovers.remove(rover);
			System.out.println(rover.executeMoves(otherRovers.toArray(new Rover[]{})));
		}
	}

	Integer maxX = 0;
	Integer maxY = 0;

	/**
	 * Read and parse the bounds input line.
	 *
	 * <p>
	 * This method reads and parses a line for the bound details.</p>
	 *
	 * <p>
	 * Bound details 2 integers representing the maximum X and Y values, similar
	 * to: 3 5</p>
	 *
	 * <p>
	 * Technically the line must match the regular expression: /[-0-9]+
	 * [-0-9]+/</p>
	 *
	 * <p>
	 * Note that negative bounds will parse but are, by definition, an error and
	 * will cause a NegativeBoundException exception.</p>
	 *
	 * <p>
	 * Bounds will be used for all rovers</p>
	 *
	 * @param scanner
	 * @throws IncorrectInputException
	 * @throws NegativeBoundException
	 */
	protected void readBounds(Scanner scanner) throws IncorrectInputException, NegativeBoundException {
		System.out.println("Enter Bounds>");
		//if (scanner.hasNext()) {
		// Get the first line, which should be 2 integers
		String input = scanner.nextLine();
		System.out.println(input);
		if (!input.matches("[-0-9]+ [-0-9]+")) {
			throw new IncorrectInputException("Input is \"" + input + "\" but was expecting 2 integers separated by a space");
		}
		String[] values = input.split(" ");
		maxX = Integer.parseInt(values[0]);
		maxY = Integer.parseInt(values[1]);
		if (maxX < 0 || maxY < 0) {
			throw new NegativeBoundException(maxX, maxY);
		}
		//}
	}

	/**
	 * Read and parse the rover input line.
	 *
	 * <p>
	 * This method reads and parses a line with rover details and returns a
	 * Rover with those details.</p>
	 *
	 * <p>
	 * Rover details should be formatted as 2 lines similar to: 1 3
	 * E<br>RMLMMMRM</p>
	 *
	 * <p>
	 * Due to the specification of the test data a single line will also be
	 * successfully parsed: 1 3 E RMLMMMRM</p>
	 *
	 * <p>
	 * Technically the details must match the regular expression /[0-9]+ [0-9]+
	 * [NEWS] [LRM]*\/</p>
	 *
	 * @param scanner the input to read
	 * @param roverName the name for the new rover, this is not included in the
	 * specification but is helpful for debugging.
	 * @return a Rover as specified
	 * @throws nz.co.gregs.kitomba.rovers.IncorrectInputException if the input
	 * does not match the require regex
	 * @throws java.text.ParseException if the direction fails to parse (note
	 * this should be impossible due to the previous check)
	 */
	protected Rover readRover(Scanner scanner, String roverName) throws IncorrectInputException, ParseException {
		System.out.println("Enter " + roverName + ">");
		// Get the rover line, which should be rover's location, heading, and moves
		String input = scanner.nextLine();
		System.out.println(input);
		final String allLegalMoves = Arrays.toString(Move.values()).replaceAll("[\\]\\[, ]", "");
		
		// There is a descrepency between the specification and the test data
		// this IF allows me to handle both cases and remove the incorrect as required
		if (input.isEmpty()) {
			return null;
		} else if (input.matches("^[0-9]+ [0-9]+ [NEWS] ["+allLegalMoves+"]+$")) {

			String[] values = input.split(" ");
			// Parse all the values before creating the rover, to help with debugging
			Integer x = Integer.parseInt(values[0]);
			Integer y = Integer.parseInt(values[1]);
			Direction direction = Direction.parseDirection(values[2]);
			String moves = values[3];
			// Create the new rover with its intended moves
			return new Rover(roverName, x, y, direction, maxX, maxY, moves);
		} else if (input.matches("^[0-9]+ [0-9]+ [NEWS]$")) {

			String[] values = input.split(" ");
			// Parse all the values before creating the rover, to help with debugging
			Integer x = Integer.parseInt(values[0]);
			Integer y = Integer.parseInt(values[1]);
			Direction direction = Direction.parseDirection(values[2]);

			input = scanner.nextLine();
			if (input.matches("^["+allLegalMoves+"]+$")) {
				String moves = input;
				// Create the new rover with its intended moves
				return new Rover(roverName, x, y, direction, maxX, maxY, moves);
			} else {
				throw new IncorrectInputException("Input is \"" + input + "\" but was expecting a series of movement instructions matching the pattern /[LRM]*/");
			}
		}
		throw new IncorrectInputException("Input is \"" + input + "\" but was expecting 2 integers, a direction, and a series of movement instructions matching the pattern /[0-9]+ [0-9]+ [NEWS] [LRM]*/");
	}

}
