package com.cg.tripreview.service;

import com.cg.tripreview.dto.Review;
import com.cg.tripreview.exceptions.DestinationDetailNotFoundException;
import com.cg.tripreview.repository.ReviewRepositoryImp;

public class ReviewServiceImp implements ReviewService {
	ReviewRepositoryImp reviewRepo = new ReviewRepositoryImp();
	@Override
	public Review addReview(Review review) throws DestinationDetailNotFoundException {
		Review myReview=reviewRepo.save(review);
		if(myReview!=null) 
			return myReview;
		throw new DestinationDetailNotFoundException("Destination not found."
				+ " Add the destination before writing reveiw!");
	}

}
