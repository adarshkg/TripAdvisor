package com.cg.tripreview.repository;

import com.cg.tripreview.dto.Review;
import com.cg.tripreview.exceptions.DestinationDetailNotFoundException;

public interface ReviewRepository {
	
	public Review save(Review review,String city) throws DestinationDetailNotFoundException;

}
