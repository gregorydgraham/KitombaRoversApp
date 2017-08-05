/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.co.gregs.kitomba.rovers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * A Rover.
 *
 * <p>
 * All rovers have a location, expressed as an integer X and Y, a direction that
 * it is facing, maximum values for the X and Y values, and a set of moves.<p>
 *
 * <p>
 * All rovers also have mininmum values for X and Y, these are defined as 0
 * (zero).</P>
 *
 * @author Gregory Graham
 */
public class Rover {

	private int x = 0;
	private int y = 0;
	private Direction facing = Direction.N;
	private String moves = "";
	
	// MaxX & MaxY could be uninitialised and final
	// but I prefer to avoid uninitialised variables
	private int maxX = 0;
	private int maxY = 0;

	// MinX & MinY are 0 by definition, 
	// I've included them to formalise the assumption
	// and made them final to avoid any accidental changes
	private final int minX = 0;
	private final int minY = 0;
	private final String name;

	Rover(String name, int xValue, int yValue, Direction directionValue, int maxXValue, int maxYValue, String movesValue) {
		this.name = name;
		this.setLocation(xValue, yValue);
		this.setBounds(maxXValue, maxYValue);
		this.setDirection(directionValue);
		this.setMoves(movesValue);
	}

	public String getName() {
		return name;
	}

	public int getX() {
		return x;
	}

	public synchronized void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public synchronized void setY(int y) {
		this.y = y;
	}

	public Direction getDirection() {
		return facing;
	}

	public final synchronized void setDirection(Direction facing) {
		this.facing = facing;
	}

	int getMinX() {
		return minX;
	}

	int getMinY() {
		return minY;
	}

	int getMaxX() {
		return maxX;
	}

	int getMaxY() {
		return maxY;
	}

	String getMoves() {
		return moves;
	}

	/**
	 * Execute all the moves defined for this rover and update the location
	 * appropriately.
	 *
	 * <p>
	 * Should an exception occur during movement, the rover will stop where it
	 * is and retain the remaining instructions (including the problematic
	 * order).
	 * </p>
	 *
	 * @param otherRovers
	 * @return the current location and heading of the rover as a string in the format: X Y H
	 * @throws MoveOutOfBoundsException
	 * @throws MoveWouldCollideWithAnotherRoverException
	 */
	public synchronized String executeMoves(Rover[] otherRovers) throws MoveOutOfBoundsException, MoveWouldCollideWithAnotherRoverException {
		Queue<Character> queue = new LinkedList<>();
		for (char c : moves.toCharArray()) {
			queue.offer(c);
		}
		while (queue.peek() != null) {
			Character instruction = queue.poll();
			Move.valueOf(""+instruction).move(this, otherRovers);
			StringBuilder str = new StringBuilder();
			Character[] remainingInstructions = queue.toArray(new Character[]{});
			for (Character c : remainingInstructions) {
				str.append(c);
			}
			moves = str.toString();
		}
		return "" + getX() + " " + getY() + " " + getDirection();
	}

	public void turnLeft() {
		setDirection(facing.left());
	}

	public void turnRight() {
		setDirection(facing.right());
	}

	public synchronized void moveForward(Rover[] otherRovers) throws MoveOutOfBoundsException, MoveWouldCollideWithAnotherRoverException {
		// default to a positve move
		int distance = 1;
		// for the 2 negative directions reverse the move
		switch (this.facing) {
			case S:
			case W:
				distance = -1 * distance;
		}

		// These are the values I will set the rover's location to
		int newX = getX();
		int newY = getY();

		// These are the values that will be tested
		// if they are legal the new value will be changed to the test value
		int testX = newX + distance;
		int testY = newY + distance;

		// N and S will change the y location, while E and W are x directions
		switch (this.facing) {
			// handle the y directions
			case N:
			case S:
				// make sure that we don't drive this billion dollar rover off an edge
				if (checkMove(newX, testY, otherRovers)) {
					// location is ok, so set the new value
					newY = testY;
				}
				break;
			// handle the x directions
			case E:
			case W:
				// make sure that we don't drive this billion dollar rover off an edge
				if (checkMove(testX, newY, otherRovers)) {
					// location is ok, so set the new value
					newX = testX;
				}
		}
		setLocation(newX, newY);

	}

	public boolean checkMove(int newX, int newY, Rover[] otherRovers) throws MoveOutOfBoundsException, MoveWouldCollideWithAnotherRoverException {
		// Driving off the plateau would be bad
		if (newX > maxX || newX < minX || newY > maxY || newY < minY) {
			throw new MoveOutOfBoundsException(this, newX, newY);
		} else {
			// Crashing into another billion dollar rover would be doubly bad
			if (otherRovers != null) {
				for (Rover other : otherRovers) {
					if (newX == other.getX() && newY == other.getY()) {
						throw new MoveWouldCollideWithAnotherRoverException(this, other, newX, newY);
					}
				}
			}
			return true;
		}
	}

	/**
	 * Convenience method to set the X and Y values
	 *
	 * @param newX
	 * @param newY
	 */
	public final synchronized void setLocation(int newX, int newY) {
		setX(newX);
		setY(newY);
	}

	private void setMoves(String movesValue) {
		this.moves = movesValue;
	}

	private void setBounds(int maxXValue, int maxYValue) {
		maxX = maxXValue;
		maxY = maxYValue;
	}

	public boolean equals(Rover other) {
		return this.facing.equals(other.facing)
				&& this.maxX == other.getMaxX()
				&& this.maxY == other.getMaxY()
				&& this.minX == other.getMinX()
				&& this.minY == other.getMinY()
				&& this.x == other.getX()
				&& this.y == other.getY()
				&& this.name.equals(other.getName());
	}

}
