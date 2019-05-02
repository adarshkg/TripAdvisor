/*
 * interface for queries for destination repository
 * */

package com.cg.tripreview.repository;

public interface DestinationQuery {
//	query to insert destination details into the destination table
	public static final String queryInsertDestination = "INSERT INTO destination(dest_city,dest_rating,dest_country) VALUES(?,?,?)";
//	query to get id from the destination table
	public static final String querySelectDestination = "SELECT dest_id from destination WHERE dest_city =?";
//	query to select data from the review table  based on the destination id
	public static final String querySelectReview = "SELECT description from review WHERE destination_id =?";
//	query to find data from the destination based on destination rating
	public static final String querySelect = "SELECT dest_city from destination WHERE dest_rating =?";
	
}
