/*
 *	@author adgangad
 * project name: TripAdvisor
 * 			This project is about adding destination and writing  review for the destination
 * 
 * 
 * 
 * 
 *  This is userinterface class.
 * Where user is adding the destination details, review details, reviewer details and fetching those details.
 * The data is coming and going through the service layer 
 */


package com.cg.tripadvisorjpa.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.cg.tripadvisorjpa.dto.Destination;
import com.cg.tripadvisorjpa.dto.Review;
import com.cg.tripadvisorjpa.dto.Reviewer;
import com.cg.tripadvisorjpa.exceptions.DestinationDetailNotFoundException;
import com.cg.tripadvisorjpa.service.DestinationServiceImp;
import com.cg.tripadvisorjpa.service.ReviewServiceImp;



public class MyApplication {
	
	final static Logger logger = Logger.getLogger(MyApplication.class);
	
	public static void main(String[] args) {
	
		
		DestinationServiceImp destinationService = new DestinationServiceImp();
		int choice =0;
		Scanner scan = new Scanner(System.in);
		do {
		System.out.println("\n1. Add Destination\n2. Add Review\n3. Search Review By city\n"
				+ "4. Search Destination By rating\n5. Exit");
		System.out.println("Enter choice");
		choice = scan.nextInt();
		switch (choice) {

		//		Getting destination details from the user and sending to service layer
		
		case 1:
			scan.nextLine();
			System.out.println("********Add Destination*********");

			List<Review> reviews = new ArrayList<Review>();
			System.out.println("Enter city");
			String city =scan.nextLine();
			System.out.println("Enter country");
			String country = scan.next();
			System.out.println("Enter rating");
			int rating = scan.nextInt();		
			Destination destination = new Destination(city, rating, country, reviews);
			
			try {
				destinationService.addDestination(destination);
			} catch (DestinationDetailNotFoundException e1) {

				System.out.println((e1.getMessage()));
			}
			break;
			
			//		Getting review details from the user sending to service layer
		
		case 2:
			System.out.println("********Add Review********");
			scan.nextLine();
			System.out.println("Enter review Destination");
			String dest =scan.next();
			scan.nextLine();
			System.out.println("Enter review");
			String rev = scan.nextLine();
		
			System.out.println("Enter your name");
			String name = scan.nextLine();
			
			System.out.println("Enter your email id");
			String email = scan.next();
			try {
				Review review = new Review(rev, new Reviewer(name,email));
				ReviewServiceImp reviewService =  new ReviewServiceImp();
				reviewService.addReview(review,dest);

			} catch (DestinationDetailNotFoundException e) {
				System.out.println((e.getMessage()));
			}
			break;
			
			//		Getting destination from the user and fetching the reviews from the service layer
		
		case 3:	
			System.out.println("********Search Review by Destination********");
			scan.nextLine();
			System.out.println("Enter destination name: ");
			String myDestination=scan.nextLine();
		
			try {
				reviews = destinationService.SearchReviewByDestination(myDestination);
				for (Review review : reviews) {
					System.out.println(review.getDescription());
				}
			} catch (DestinationDetailNotFoundException e) {
				System.out.println((e.getMessage()));
			}
				
			break;
		 
			//		Getting rating from the user and fetching back the specified destination  from service layer
			
		case 4:
			System.out.println("*********Search Destination by rating***************");
			scan.nextLine();
			System.out.println("Enter the destination rating");
			int destinationRating = scan.nextInt();
			List<Destination> destinations;
			try {
				destinations = destinationService.SearchDestinationByRating(destinationRating);
		
				for (Destination destination2 : destinations) {
					System.out.println(destination2.getCity());
				}
			} catch (DestinationDetailNotFoundException e) {
				
				System.out.println((e.getMessage()));
			}
				
		    break;
		case 5:
			break;
		default:
			break;
		}
		}while(choice!=5);

	}

}
