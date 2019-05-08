 /*	@author adgangad
 * project name: TripAdvisor
 * 			This is Destination repsoitory interface 
 * 
*/
package com.cg.tripadvisorjpa.repository;

import java.util.List;

import com.cg.tripadvisorjpa.dto.Destination;
import com.cg.tripadvisorjpa.dto.Review;
import com.cg.tripadvisorjpa.exceptions.DestinationDetailNotFoundException;


public interface DestinationRepository {
	
	
	public Destination save(Destination destination) throws DestinationDetailNotFoundException;
	public List<Review> findReviewByDestination(String city) throws DestinationDetailNotFoundException;
	public List<Destination> findDestinationByRating(int rating) throws DestinationDetailNotFoundException;

}
