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
enum Move {
	L(),R(),M();

	void move(Rover rover, Rover[] otherRovers) throws MoveOutOfBoundsException, MoveWouldCollideWithAnotherRoverException {
			switch (this) {
				case L:
					rover.turnLeft();
					break;
				case R:
					rover.turnRight();
					break;
				case M:
					rover.moveForward(otherRovers);
					break;
			}
		
	}
}
