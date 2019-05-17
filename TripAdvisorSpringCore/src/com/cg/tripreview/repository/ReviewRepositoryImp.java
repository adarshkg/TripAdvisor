
/*
 * /
 * @author-adgangad
 * 
 * 	In this class where the review details and reviewer details are stored
 * 
 * 
 * 
 * */
package com.cg.tripreview.repository;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.cg.tripreview.dbutil.DbUtil;
import com.cg.tripreview.dto.Destination;
import com.cg.tripreview.dto.Review;

@Repository
public class ReviewRepositoryImp implements ReviewRepository  {

	
/** 		save -->[parameter-->Review review, String city, return type-->Review]
 * 
 * * @author adgangad
 * method name: save() 
 * params:- Review review   
 * return type :- Review review
 * 
 * 
 * */
	
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
