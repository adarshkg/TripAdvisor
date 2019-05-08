/*
 * @author - adgangad
 */
package com.cg.tripadvisorjpa.service;

import com.cg.tripadvisorjpa.dto.Review;
import com.cg.tripadvisorjpa.exceptions.DestinationDetailNotFoundException;



public interface ReviewService {
	
	public Review addReview(Review review,String city) throws DestinationDetailNotFoundException;
	
}
