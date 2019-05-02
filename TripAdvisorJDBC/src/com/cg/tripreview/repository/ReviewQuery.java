/*
 * interface for queries for the ReviewRepository
 * */

package com.cg.tripreview.repository;

public interface ReviewQuery {
	
//	 query for inserting the review to the review table 
	public static final String queryInsertReview = "INSERT INTO review(description,destination_id,reviewer_id) VALUES(?,?,?)";
	
//	 query for inserting reviewer to the reviewer table	
	public static final String queryInsertReviewer ="INSERT INTO reviewer(name,email) VALUES(?,?)";
	
//	query for finding the destination id using destination city
	public static final String querySelectDestination = "SELECT dest_id FROM destination WHERE dest_city = ?";
	
//	query for finding the reviewer id using the mail of reviewer
	public static final String querySelectReviewer = "SELECT reviewer_id FROM reviewer WHERE email = ?";
}
