/*
 * 
 * One Function
 * 		1.save -->[parameter-->Review review, String city, return type-->Review]
 * 
 * 
 * 
 * */



package com.cg.tripreview.repository;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



import com.cg.tripreview.dto.Review;
import com.cg.tripreview.exceptions.DestinationDetailNotFoundException;
import com.cg.tripreview.util.DBUtil;
import java.sql.*;


public class ReviewRepositoryImp implements ReviewRepository  {
	PreparedStatement pstm;
	Statement stmt;
	ResultSet rs;
	Connection conn;
	@Override
	public Review save(Review review,String city) throws DestinationDetailNotFoundException {
		
			conn = DBUtil.getConnetcion();
			int dest_id=0;
			int rev_id=0;
			try {
			
	
//			fetching the destination id from database and storing it in a variable
			try{
			pstm = conn.prepareStatement(ReviewQuery.querySelectDestination);
			
			pstm.setString(1, city);
			rs =pstm.executeQuery();
		    rs.next();
			dest_id = rs.getInt("dest_id");
			}catch(SQLException e) {

//			if the sepcified destination is not there in the table(dest_id not found) it will throw this exception				
				throw new DestinationDetailNotFoundException("Destination Not Found");
			}
			
			
//			Inserting the reviewer details in database
			try {
			pstm = conn.prepareStatement(ReviewQuery.queryInsertReviewer);

			pstm.setString(1,review.getReviewer().getName());
			pstm.setString(2,review.getReviewer().getEmail());
			pstm.executeUpdate();
			}catch(SQLException e) {
				throw new DestinationDetailNotFoundException("Email ID already registered!");
			}
//			Fetching the reviewer id using the mail id
			
			pstm = conn.prepareStatement(ReviewQuery.querySelectReviewer);
			
			pstm.setString(1, review.getReviewer().getEmail());
			rs =pstm.executeQuery();
		    rs.next();
			rev_id = rs.getInt("reviewer_id");
			
	
//          Inserting the review in the database
		
		
			pstm = conn.prepareStatement(ReviewQuery.queryInsertReview);
			

			pstm.setString(1, review.getDescription());
			pstm.setInt(2, dest_id);
			pstm.setInt(3, rev_id);
			pstm.executeUpdate();
			
	
		} catch (SQLException e) {
//			
			throw new DestinationDetailNotFoundException("Review not added!");
		}finally {
			try {
//			closing the connection and prepare statement
				pstm.close();
				conn.close();
			} catch (SQLException e) {

				throw new DestinationDetailNotFoundException("Connection not closed!");
			}
			
		}
		
				 return review;
		}
		
	}


