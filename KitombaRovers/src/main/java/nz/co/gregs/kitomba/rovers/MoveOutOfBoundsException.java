/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.co.gregs.kitomba.rovers;

/**
 *
 * @author greg
 */
public class MoveOutOfBoundsException extends Exception {

	private static final long serialVersionUID = 1L;

	private final Rover rover;
	private final int x;
	private final int y;

	public MoveOutOfBoundsException(Rover aThis, int x, int y) {
		this.rover = aThis;
		this.x = x;
		this.y = y;
	}

	@Override
	public String getMessage() {
		return "Move Will Place The Rover Out Of Bounds: intended location = ("+x+", "+y+"), bounds = ("
				+rover.getMinX()+", "
				+rover.getMinY()+", "
				+rover.getMaxX()+", "
				+rover.getMaxY()+", "
				;
	}
	
	
	
}
