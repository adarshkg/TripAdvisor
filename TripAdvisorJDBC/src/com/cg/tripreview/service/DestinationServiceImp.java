/*
 * Three function :-
 * 			
 * 			1.add destination()  [parameters-->Destination destination , return type-->Destination destination]
 *		    2.SearchReviewByDestination() [parameters-->string myDestination,return type---->List of Reviews]
 *			3.SearchDestinationByRating() [parameters-->int rating,return type---->List of Destination]
 * 
 * This class is sending the data to the repository layer and then fetching the details from repository layer
 * */




package com.cg.tripreview.service;

import java.util.List;

import com.cg.tripreview.dto.Destination;
import com.cg.tripreview.dto.Review;
import com.cg.tripreview.exceptions.DestinationDetailNotFoundException;
import com.cg.tripreview.repository.DestinationRepositoryImp;

public class DestinationServiceImp implements DestinationService{
	DestinationRepositoryImp destRepo;

//	creating an destination repository object
	public DestinationServiceImp() {
		 destRepo = new DestinationRepositoryImp();
	}
	
//	 calling the save function from the destination repository
	@Override
	public Destination addDestination(Destination destination) throws DestinationDetailNotFoundException {
		
		return destRepo.save(destination);
	}

/*	calling the find function from the repository where searching using destination city and returning the reveiw
	and if the destination is not found then throws an exception */
	@Override
	public List<Review> SearchReviewByDestination(String myDestination) throws DestinationDetailNotFoundException {
		if(destRepo.findReviewByDestination(myDestination)==null)
			throw new DestinationDetailNotFoundException("Destination not found");
		return destRepo.findReviewByDestination(myDestination);
	}
	
//	calling the find function from the repository where searching using rating and returning the destination object if the destination is not found then throwing an exception
	@Override
	public List<Destination> SearchDestinationByRating(int rating) throws DestinationDetailNotFoundException {
		if( destRepo.findDestinationByRating(rating).isEmpty())
			throw new DestinationDetailNotFoundException("Destination not found");
		return destRepo.findDestinationByRating(rating);
	}

	

}
