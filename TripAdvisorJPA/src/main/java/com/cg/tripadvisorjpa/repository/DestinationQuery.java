 /*	@author adgangad
 * project name: TripAdvisor
 * 			This is Destination repsoitory interface 
 * 
*/
package com.cg.tripadvisorjpa.repository;

public interface DestinationQuery {
	
//	query to get destination from the destination table using city
	String querySelectDestinationByCity = "select d from Destination d where city=?";
	
//	query to get destination from the destination table using the rating
	String querySelectDestinationByRating= "select d from Destination d where rating=?";
}
