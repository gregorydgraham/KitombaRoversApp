
package nz.co.gregs.kitomba.rovers;

import java.text.ParseException;

/**
 * An Enumeration representing the 4 directions used in this program.
 * 
 * <p>Valid directions are: N, E, W, and S.</p>
 *
 * @author Gregory Graham
 */
public enum Direction {

	N(), E(), W(), S();

	public Direction left() {
		switch (this) {
			case N:
				return W;
			case W:
				return S;
			case S:
				return E;
			case E:
				return N;

		}
		return this;
	}

	public Direction right() {
		switch (this) {
			case N:
				return E;
			case W:
				return N;
			case S:
				return W;
			case E:
				return S;

		}
		return this;
	}

	public static Direction parseDirection(String possibleDirection) throws ParseException {
		if (possibleDirection == null) {
			throw new ParseException("Unable to parse NULL string", 0);
		} else if (possibleDirection.length() == 0) {
			throw new ParseException("Unable to parse empty string", 0);
		} else {
			switch (possibleDirection.substring(0, 1)) {
				case "N":
					return N;
				case "E":
					return E;
				case "W":
					return W;
				case "S":
					return S;
				default:
					throw new ParseException("Unable to parse \"" + possibleDirection + "\" as a direction as it's first character is not one of N, E, W, or S", 0);

			}
		}
	}
}
