package com.cg.tripreview.service;

import java.util.List;

import com.cg.tripreview.dto.Destination;
import com.cg.tripreview.dto.Review;
import com.cg.tripreview.exceptions.DestinationDetailNotFoundException;
import com.cg.tripreview.repository.DestinationRepository;
import com.cg.tripreview.repository.DestinationRepositoryImp;

public class DestinationServiceImp implements DestinationService{
	 DestinationRepositoryImp destRepo = new DestinationRepositoryImp();
	@Override
	public Destination addDestination(Destination destination) {
		
		return destRepo.save(destination);
	}

	@Override
	public List<Review> SearchReviewByDestination(String myDestination) throws DestinationDetailNotFoundException {
		if(destRepo.findReviewByDestination(myDestination)==null)
			throw new DestinationDetailNotFoundException("Destination not found");
		return destRepo.findReviewByDestination(myDestination);
	}

	@Override
	public List<Destination> SearchDestinationByRating(int rating) throws DestinationDetailNotFoundException {
		if( destRepo.findDestinationByRating(rating).isEmpty())
			throw new DestinationDetailNotFoundException("Destination not found");
		return destRepo.findDestinationByRating(rating);
	}

	

}
