/*
 * 
 *	@author adgangad
 * project name: TripAdvisor
 * 			This is Review repsoitory interface 
 * 
 * 
 * One Function
 * 		1.save -->[parameter-->Review review, String city, return type-->Review]
 * 
 * 
 * 
 * */

package com.cg.tripadvisorjpa.repository;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import com.cg.tripadvisorjpa.dto.Destination;
import com.cg.tripadvisorjpa.dto.Review;
import com.cg.tripadvisorjpa.exceptions.DestinationDetailNotFoundException;
import com.cg.tripadvisorjpa.util.DbUtil;

public class ReviewRepositoryImp implements ReviewRepository  {
		EntityManager em;
	
	public Review save(Review review, String city) throws DestinationDetailNotFoundException {
		
//		fetching the destination id from database and storing it in a variable
		try {
			
		em= DbUtil.getConnection();
		
		Destination destination = new Destination();
		List<Review> reviews = new ArrayList<Review>();
		
		
    	TypedQuery<Destination> query = em.createQuery(ReviewQuery.querySelectDestination,Destination.class);
		query.setParameter(1, city);
		destination = query.getSingleResult();
		
		reviews = destination.getReview();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          
		reviews.add(review);
		destination.setReview(reviews);
		
//		persisting the reviewer details and destination details in database
		em.persist(review);
		em.persist(destination);
		em.getTransaction().commit();
		return review;
		}catch (Exception e) {
			
//			if the sepcified destination is not there in the table(dest_id not found) it will throw this exception				
			throw new DestinationDetailNotFoundException("Destination Not Found");

		}finally {
			em.close();
		}
	}
	
		
	}


