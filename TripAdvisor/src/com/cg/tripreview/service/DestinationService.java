package com.cg.tripreview.service;

import java.util.List;

import com.cg.tripreview.dto.Destination;
import com.cg.tripreview.dto.Review;
import com.cg.tripreview.exceptions.DestinationDetailNotFoundException;

public interface DestinationService {
	public Destination addDestination(Destination destination);
	public List<Destination> SearchDestinationByRating(int rating) throws DestinationDetailNotFoundException;
	public List<Review> SearchReviewByDestination(String myDestination) throws DestinationDetailNotFoundException;
}
