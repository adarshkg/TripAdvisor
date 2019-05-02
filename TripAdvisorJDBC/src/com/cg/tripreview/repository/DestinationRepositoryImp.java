/*
 * 
 * 
 * Three functions
 * 		1.save()  [parameters-->Destination destination,return type-->Destination]
 * 		2.findReviewByDestination() -->[parameters-->String city, return type-->List<Review>]
 * 		3.findDestinationByRating() -->[parameters-->int rating, retrun type-->List<Destination>]
 * */




package com.cg.tripreview.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import com.cg.tripreview.dto.Destination;
import com.cg.tripreview.dto.Review;
import com.cg.tripreview.exceptions.DestinationDetailNotFoundException;
import com.cg.tripreview.util.DBUtil;

public class DestinationRepositoryImp implements DestinationRepository{
	PreparedStatement pstm;
	
//	save function will accept a destination object from the service layer and save to the destination table
	@Override
	public Destination save(Destination destination) throws DestinationDetailNotFoundException {

//		creating a connection to the database.
		Connection conn = DBUtil.getConnetcion();

//		Inserting destination details to the destination table
		try {
			
			pstm = conn.prepareStatement(DestinationQuery.queryInsertDestination);
			pstm.setString(1, destination.getCity());
			pstm.setInt(2, destination.getRating());
			pstm.setString(3, destination.getCountry());
			
			pstm.executeUpdate();
			
		} catch (SQLException e) {
			
// 		if the destination already there it will throw an exception .
			throw new DestinationDetailNotFoundException("Destination already exist");
		}finally {
		
			try {
				
//				closing preaparestament and connection
				pstm.close();
				conn.close();
			} catch (SQLException e) {
				
//				if the connection and prepare statement not closed it will throw an exception
				throw new DestinationDetailNotFoundException("Connection not  closed");
			}
		}
		return destination;
	}
	
//		This function will accept city and find the review and reviewer details regarding that specific destination 
	@Override
	public List<Review> findReviewByDestination(String city) throws DestinationDetailNotFoundException {
	
		List<Review> myList = new ArrayList<>();
		

		Connection con = null ;
//		finding the review for the specific destination
		try {
			
//			creating a connection to the database.
			 con = DBUtil.getConnetcion();
			 ResultSet rs;
			 
//			finding the destination id using the destination city and storing into a variable called "dest_id".
			pstm = con.prepareStatement(DestinationQuery.querySelectDestination);
			pstm.setString(1, city);
			
			rs =pstm.executeQuery();
			
//			finding the review using the destination id(foriegn key in the review table).
			rs.next();
			int dest_id = rs.getInt("dest_id");
			pstm = con.prepareStatement(DestinationQuery.querySelectReview);
			pstm.setInt(1, dest_id);
			
//			review description is set to the  review object. Adding to an array list.
			rs = pstm.executeQuery();
			while(rs.next()) {
				String description = rs.getString("description");
				Review review = new Review();
				review.setDescription(description);
				myList.add(review);
			}
			
	
		} catch (SQLException e) {
			
//			if no reveiw found in the table it will throw an exception 
			throw new DestinationDetailNotFoundException("review not found");
			
		} 
		finally {
			
			try {
				
				pstm.close();
				con.close();
			} catch (SQLException e) {

//				if the connection and prepare statement not closed it will throw an exception
				throw new DestinationDetailNotFoundException("connection not able to close");
			}
		}
			return myList;
		

		
	}
	
//	this function will find the dstinations based on the rating of the destination
	@Override
	public List<Destination> findDestinationByRating(int rating) throws DestinationDetailNotFoundException {
		List<Destination> myList =  new ArrayList<>();
		Connection conn = null ;
		try {
//			creating a connection to the database.
			 conn = DBUtil.getConnetcion();
			ResultSet rs;
			
//			finding the destination cities using the rating of destination
			pstm = conn.prepareStatement(DestinationQuery.querySelect);	
			pstm.setInt(1, rating);
			rs = pstm.executeQuery();
		    while(rs.next())
		    {
		    	String dest_city = rs.getString("dest_city");
		    	Destination destination = new Destination();
		    	destination.setCity(dest_city);
		    	
		    	myList.add(destination);

		    }
			
		}  catch (SQLException e) {
			
//			if there is not destination with the specified rating this will throw an exception
			throw new DestinationDetailNotFoundException("Destination detail not found");
		}finally {
			try {
				
				pstm.close();
				conn.close();
			} catch (SQLException e) {
				
//				if the connection and prepare statement not closed ,it will throw an exception
				throw new DestinationDetailNotFoundException("connection not able to close");
			}
			
		}
		return myList;
	}
}