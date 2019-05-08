 /*	@author adgangad
 * project name: TripAdvisor
 * 			This is review repository interface 
 * 
*/
package com.cg.tripadvisorjpa.repository;

import com.cg.tripadvisorjpa.dto.Review;
import com.cg.tripadvisorjpa.exceptions.DestinationDetailNotFoundException;

public interface ReviewRepository {
	
	public Review save(Review review,String city) throws DestinationDetailNotFoundException;

}
