package com.cg.tripreview.repository;

import java.util.List;

import com.cg.tripreview.dto.Destination;
import com.cg.tripreview.dto.Review;

public interface DestinationRepository {
	public Destination save(Destination destination);
	public List<Review> findReviewByDestination(String city);
	public List<Destination> findDestinationByRating(int rating);
}
