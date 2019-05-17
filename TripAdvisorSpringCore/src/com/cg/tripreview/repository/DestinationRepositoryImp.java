/*
 * @author-adgangad
 * 
 * Three functions
 * 		1.save()  [parameters-->Destination destination,return type-->Destination]
 * 		2.findReviewByDestination() -->[parameters-->String city, return type-->List<Review>]
 * 		3.findDestinationByRating() -->[parameters-->int rating, retrun type-->List<Destination>]
 * */



package com.cg.tripreview.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cg.tripreview.dbutil.DbUtil;
import com.cg.tripreview.dto.Destination;
import com.cg.tripreview.dto.Review;
import com.cg.tripreview.exceptions.DestinationDetailNotFoundException;

@Repository
public class DestinationRepositoryImp implements DestinationRepository{	
	
/**	save function will accept a destination object from the service layer and save to the destination table
 * * @author adgangad
 * method name: save()
 * param:- destination (Destination) 
 * return  :- destination(Destination)
 *  
 *  
 *  
 *  */

	@Override
	public Destination save(Destination destination) throws DestinationDetailNotFoundException {
		
		for (Destination dest : DbUtil.destinationList) {
			if(dest.getCity().equals(destination.getCity())) {
				return null;
			}
		}
			
				DbUtil.destinationList.add(destination);
				
				return destination;
		
		}
		
/**	This function will accept city and find the review and reviewer details regarding that specific destination 
 * 
 * * @author adgangad
 * method name: findReviewByDestination()
 * param:- String city  
 * return type :- Review review
 * 
 * */

	@Override
	public List<Review> findReviewByDestination(String city) {
		for (Destination destination : DbUtil.destinationList ) 
			if(destination.getCity().equalsIgnoreCase((city)))
				return destination.getReview();
		return null;
	}

/**	this function will find the destinations based on the rating of the destination
 * 
 *  * @author adgangad
 * method name: findDestinationByRating()
 * param:- int rating  
 * return type :- List<Destination>
 *  
 *  */

	@Override
	public List<Destination> findDestinationByRating(int rating) {
		List<Destination> destinationList = new ArrayList<>();
		for (Destination destination : DbUtil.destinationList ) {
			if(destination.getRating()==rating) { 
				destinationList.add(destination);
			}
		}
		return destinationList;
	}

}
