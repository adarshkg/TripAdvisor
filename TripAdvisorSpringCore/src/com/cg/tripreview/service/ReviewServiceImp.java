
/*	@author adgangad
 * project name: TripAdvisor
 * 			This project is about adding destination and writing  review for the destination
 * One function :-
 * 			
 *	1.addReview()  [parameters-->Review review,String city , return type-->Review review]
 *
 *	Here the data is sending to the repository layer
 * 
 * */

package com.cg.tripreview.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.tripreview.dto.Review;
import com.cg.tripreview.exceptions.DestinationDetailNotFoundException;
import com.cg.tripreview.repository.ReviewRepositoryImp;
@Service("reviewService")
public class ReviewServiceImp implements ReviewService {
	
	@Autowired
	ReviewRepositoryImp reviewRepo;
	
/**
 *  * @author adgangad
 * method name: addReview
 * param:- review (Review)
 * returns :- review(Review)
 * 
 * 	calling the save function from the reveiw repsository class and passing the reveiw and city and returning the reveiw,
	if the destination is not found then throws an exception*/
	@Override
	public Review addReview(Review review) throws DestinationDetailNotFoundException {
		Review myReview=reviewRepo.save(review);
		if(myReview!=null) 
			return myReview;
		throw new DestinationDetailNotFoundException("Destination not found."
				+ " Add the destination before writing reveiw!");
	}

}
