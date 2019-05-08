/*
 * 
 *	@author adgangad
 *			 project name: TripAdvisor
 *
 *  Functions :-
 * 		
 *
 *	Here the data is sending to the repository layer
 * 
 * */



package com.cg.tripadvisorjpa.service;

import org.apache.log4j.Logger;

import com.cg.tripadvisorjpa.dto.Review;
import com.cg.tripadvisorjpa.exceptions.DestinationDetailNotFoundException;
import com.cg.tripadvisorjpa.repository.ReviewRepositoryImp;
import com.cg.tripadvisorjpa.ui.MyApplication;

public class ReviewServiceImp implements ReviewService {
	private static int reviewId=0;
	private static int reviewerId=0;
	ReviewRepositoryImp reviewRepo = new ReviewRepositoryImp();

//	 [parameters-->Review review,String city , return type-->Review review]
	public Review addReview(Review review, String city) throws DestinationDetailNotFoundException {
		final Logger logger = Logger.getLogger(ReviewServiceImp.class);
		
		logger.info("Entering to the add review function");
		reviewId++;
		reviewerId++;
		review.setId(reviewId);
		review.getReviewer().setId(reviewerId);
		Review myReview=reviewRepo.save(review,city);
		if(myReview!=null) 
			return myReview;
		throw new DestinationDetailNotFoundException("Destination not found. Add the destination before writing reveiw!");
	
	}


}
