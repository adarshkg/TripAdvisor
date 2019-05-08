/*
 *  *	@author adgangad
 * project name: TripAdvisor
 * 			This is Destination dto class where data is set to each variable
 * 
 *
 * 
 * Three functions
 * 		1.save()  [parameters-->Destination destination,return type-->Destination]
 * 		2.findReviewByDestination() -->[parameters-->String city, return type-->List<Review>]
 * 		3.findDestinationByRating() -->[parameters-->int rating, retrun type-->List<Destination>]
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


public class DestinationRepositoryImp implements DestinationRepository{
	EntityManager em;

//	save function will accept a destination object from the service layer and save to the destination table
	public Destination save(Destination destination) throws DestinationDetailNotFoundException {

		try {
//		creating a connection to the database.
		em= DbUtil.getConnection();
		
//		persisting destination details to the destination table
		em.persist(destination);
		em.getTransaction().commit();
		return destination;
// 		if the destination already there it will throw an exception .
		}catch (Exception e) {
			throw new DestinationDetailNotFoundException("Destination already exist");
		}finally {
			em.close();
		}
		
	}
	
//	This function will accept city and find the review and reviewer details regarding that specific destination 
	public List<Review> findReviewByDestination(String city) throws DestinationDetailNotFoundException {
		try{
//			creating a connection to the database.
		em=DbUtil.getConnection();
		List<Review> reviews = new ArrayList<Review>();
		Destination destination = new Destination();
		
//		finding the review.
		TypedQuery<Destination> query = em.createQuery(DestinationQuery.querySelectDestinationByCity,Destination.class);
		query.setParameter(1, city);	
		destination = query.getSingleResult();
		reviews =destination.getReview();
		
		return reviews;
		
//		if no reveiw found in the table it will throw an exception 
		}catch (Exception e) {
			throw new DestinationDetailNotFoundException("review not found");

		}
		finally {
			em.close();
		}
	}

//	this function will find the dstinations based on the rating of the destination
	public List<Destination> findDestinationByRating(int rating) throws DestinationDetailNotFoundException {
		try {
			
		em=DbUtil.getConnection();
		List<Destination> destinations = new ArrayList<Destination>();
		
		
//		finding the destination cities using the rating of destination
		TypedQuery<Destination> query = em.createQuery(DestinationQuery.querySelectDestinationByRating,Destination.class);
		query.setParameter(1, rating);
		
		destinations =query.getResultList();
		
		
		return destinations;
		}catch (Exception e) {
			throw new DestinationDetailNotFoundException("Destination detail not found");
		}finally {
			em.close();
		}
		
	}
	
	
	}