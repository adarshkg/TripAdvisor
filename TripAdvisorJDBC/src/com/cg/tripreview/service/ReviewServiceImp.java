/*
 * One function :-
 * 			
 *	1.addReview()  [parameters-->Review review,String city , return type-->Review review]
 *
 *	Here the data is sending to the repository layer
 * 
 * */




package com.cg.tripreview.service;

import com.cg.tripreview.dto.Review;
import com.cg.tripreview.exceptions.DestinationDetailNotFoundException;
import com.cg.tripreview.repository.ReviewRepositoryImp;

public class ReviewServiceImp implements ReviewService {
	ReviewRepositoryImp reviewRepo = new ReviewRepositoryImp();
/*	calling the save function from the reveiw repsository class and passing the reveiw and city and returning the reveiw,
	if the destination is not found then throws an exception*/
	@Override
	public Review addReview(Review review,String city) throws DestinationDetailNotFoundException {
		Review myReview=reviewRepo.save(review,city);
		if(myReview!=null) 
			return myReview;
		throw new DestinationDetailNotFoundException("Destination not found. Add the destination before writing reveiw!");
	}

}
