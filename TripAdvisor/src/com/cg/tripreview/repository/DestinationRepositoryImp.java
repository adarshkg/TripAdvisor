package com.cg.tripreview.repository;

import java.util.ArrayList;
import java.util.List;

import com.cg.tripreview.dbutil.DbUtil;
import com.cg.tripreview.dto.Destination;
import com.cg.tripreview.dto.Review;

public class DestinationRepositoryImp implements DestinationRepository{	
	@Override
	public Destination save(Destination destination) {
		DbUtil.destinationList.add(destination);
		return destination;
	}

	@Override
	public List<Review> findReviewByDestination(String city) {
		for (Destination destination : DbUtil.destinationList ) 
			if(destination.getCity().equalsIgnoreCase((city)))
				return destination.getReview();
		return null;
	}

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
