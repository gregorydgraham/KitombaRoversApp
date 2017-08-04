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
public class IncorrectInputException extends Exception {

	private static final long serialVersionUID = 1L;

	private final String message;

	public IncorrectInputException(String messageForException) {
		this.message = messageForException;
	}

	@Override
	public String getMessage() {
		return message;
	}
	
	
}
