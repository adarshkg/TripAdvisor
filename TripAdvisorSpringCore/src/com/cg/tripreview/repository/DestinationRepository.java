/*
 *	@author adgangad
 */
package com.cg.tripreview.repository;

import java.util.List;

import com.cg.tripreview.dto.Destination;
import com.cg.tripreview.dto.Review;
import com.cg.tripreview.exceptions.DestinationDetailNotFoundException;

public interface DestinationRepository {
	public Destination save(Destination destination) throws DestinationDetailNotFoundException;
	public List<Review> findReviewByDestination(String city);
	public List<Destination> findDestinationByRating(int rating);
}
