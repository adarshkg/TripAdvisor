/*
 * User defined exception for the application
 * */

package com.cg.tripadvisorjpa.exceptions;



public class DestinationDetailNotFoundException extends Exception {

	
	public DestinationDetailNotFoundException() {
		super();

	}
	public DestinationDetailNotFoundException(String message) {
		super(message);

	}

}
