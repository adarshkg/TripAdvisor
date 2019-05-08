/*
 * 
 * @author - adgangad
 */
package com.cg.tripadvisorjpa.service;

import java.util.List;

import com.cg.tripadvisorjpa.dto.Destination;
import com.cg.tripadvisorjpa.dto.Review;
import com.cg.tripadvisorjpa.exceptions.DestinationDetailNotFoundException;



public interface DestinationService {

	public Destination addDestination(Destination destination) throws DestinationDetailNotFoundException;
	public List<Destination> SearchDestinationByRating(int rating) throws DestinationDetailNotFoundException;
	public List<Review> SearchReviewByDestination(String myDestination) throws DestinationDetailNotFoundException;
}
