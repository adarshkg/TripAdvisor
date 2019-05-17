/*
 *	@author adgangad
 */
package com.cg.tripreview.service;

import java.util.List;

import com.cg.tripreview.dto.Review;
import com.cg.tripreview.exceptions.DestinationDetailNotFoundException;

public interface ReviewService {
	
	public Review addReview(Review review) throws DestinationDetailNotFoundException;
	
}
