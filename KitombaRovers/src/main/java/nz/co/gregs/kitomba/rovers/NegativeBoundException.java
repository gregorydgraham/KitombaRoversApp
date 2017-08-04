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
class NegativeBoundException extends Exception{
	
	private static final long serialVersionUID = 1L;

	NegativeBoundException(Integer maxX, Integer maxY) {
		super("Bounds of the plateau may not be negative but bounds supplied were: "+maxX+", "+maxY);
	}
	
	
}
