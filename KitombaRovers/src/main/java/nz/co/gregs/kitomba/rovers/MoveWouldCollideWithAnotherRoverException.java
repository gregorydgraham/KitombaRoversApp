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
public class MoveWouldCollideWithAnotherRoverException extends Exception {

	private static final long serialVersionUID = 1L;

	public MoveWouldCollideWithAnotherRoverException(Rover aThis, Rover other, int newX, int newY) {
		super("Moving "+aThis.getName()+" to ("+newX+", "+newY+") would cause a collision with "+other.getName()+" which is already at that location");
	}
	
}
