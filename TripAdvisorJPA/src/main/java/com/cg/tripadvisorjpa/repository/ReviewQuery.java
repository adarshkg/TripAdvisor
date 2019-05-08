 /*	@author adgangad
 * project name: TripAdvisor
 * 			This is review query interface
 * 
*/
package com.cg.tripadvisorjpa.repository;

public interface ReviewQuery {

//	query to get destination from the destination table using city
	String querySelectDestination = "SELECT d FROM Destination d WHERE city=?";

}
