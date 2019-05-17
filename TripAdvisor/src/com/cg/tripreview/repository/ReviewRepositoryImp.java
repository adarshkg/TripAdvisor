package com.cg.tripreview.repository;


import java.util.List;

import com.cg.tripreview.dbutil.DbUtil;
import com.cg.tripreview.dto.Destination;
import com.cg.tripreview.dto.Review;

public class ReviewRepositoryImp implements ReviewRepository  {

	@Override
	public Review save(Review review) {
		
		for (Destination destination : DbUtil.destinationList) {
			if(destination.getCity().equalsIgnoreCase(review.getCity())) {
				 List <Review> reviews = destination.getReview();
				 reviews.add(review);
				 destination.setReview(reviews);
				 return review;
			}
		}
		return null;
	}

}
