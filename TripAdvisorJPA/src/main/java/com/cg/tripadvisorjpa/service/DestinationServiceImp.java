/*
 * @author - adgangad
 * Three function :-
 * 			
 * 			
 * 
 * This class is sending the data to the repository layer and then fetching the details from repository layer
 * */

package com.cg.tripadvisorjpa.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.cg.tripadvisorjpa.dto.Destination;
import com.cg.tripadvisorjpa.dto.Review;
import com.cg.tripadvisorjpa.exceptions.DestinationDetailNotFoundException;
import com.cg.tripadvisorjpa.repository.DestinationRepositoryImp;



public class DestinationServiceImp implements DestinationService{
	private static int dest_id=0;
	DestinationRepositoryImp destRepo;
	public DestinationServiceImp() {
		 destRepo = new DestinationRepositoryImp();
	}
	
//	  [parameters-->Destination destination , return type-->Destination destination]
	public Destination addDestination(Destination destination) throws DestinationDetailNotFoundException {
		
		dest_id++;
		destination.setId(dest_id);
		return destRepo.save(destination);
	
	}
	
//	  [parameters-->string myDestination,return type---->List of Reviews]
	public List<Destination> SearchDestinationByRating(int rating) throws DestinationDetailNotFoundException {
		
		if( destRepo.findDestinationByRating(rating).isEmpty())
			throw new DestinationDetailNotFoundException("Destination not found");
		return destRepo.findDestinationByRating(rating);
	
	}
	
//	[parameters-->int rating,return type---->List of Destination]
	public List<Review> SearchReviewByDestination(String myDestination) throws DestinationDetailNotFoundException {
		if(destRepo.findReviewByDestination(myDestination)==null)
			throw new DestinationDetailNotFoundException("Destination not found");
		return destRepo.findReviewByDestination(myDestination);
	}
	 
}
