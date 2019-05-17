package com.cg.tripreview.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cg.tripreview.dto.Destination;
import com.cg.tripreview.dto.Review;
import com.cg.tripreview.dto.Reviewer;
import com.cg.tripreview.exceptions.DestinationDetailNotFoundException;
import com.cg.tripreview.service.DestinationServiceImp;
import com.cg.tripreview.service.ReviewServiceImp;

public class MyApplication {

	public static void main(String[] args) {
		DestinationServiceImp destinationService = new DestinationServiceImp();
		int choice =0;
		Scanner scan = new Scanner(System.in);
		do {
		System.out.println("1. Add Destination \n2. Add Review \n3. Search Review By city\n"
				+ "4.Search Destination By rating\n5. Exit");
		System.out.println("Enter choice");
		choice = scan.nextInt();
		switch (choice) {
		case 1:
			System.out.println("********Add Destination*********");
			List <Review> reviews = new ArrayList<>();
			System.out.println("Enter city");
			String city =scan.next();
			System.out.println("Enter country");
			String country = scan.next();
			System.out.println("Enter rating");
			int rating = scan.nextInt();		
			Destination destination = new Destination(city, rating, country, reviews);
			
			destinationService.addDestination(destination);
			break;
		case 2:
			System.out.println("********Add Review********");
			scan.nextLine(); 
			System.out.println("Enter review Destination");
			String dest =scan.next();
			
			System.out.println("Enter review ID");
			int Id =scan.nextInt();
			
			System.out.println("Enter review");
			String rev = scan.next();
			
			try {
				Review review = new Review( Id,dest, rev, new Reviewer(1, "Adarsh", "adarsh@gmail.com"));
				ReviewServiceImp reviewService =  new ReviewServiceImp();
				reviewService.addReview(review);

			} catch (DestinationDetailNotFoundException e) {
				System.out.println(e.getMessage());
			}
			
			break;
		case 3:
			System.out.println("********Search Review by City********");
			scan.nextLine();
			System.out.println("Enter destination name: ");
			String myDestination=scan.nextLine();
	
			try {
				reviews = destinationService.SearchReviewByDestination(myDestination);
				System.out.println(reviews);
			} catch (DestinationDetailNotFoundException e) {
				System.out.println(e.getMessage());
			}
			
			break;
		case 4:
			System.out.println("*********Search Destination By Rating***************");
			scan.nextLine();
			System.out.println("Enter the destination rating");
			int destinationRating = scan.nextInt();
			List<Destination> destinations;
			try {
				destinations = destinationService.SearchDestinationByRating(destinationRating);
				System.out.println(destinations);
				for (Destination destination2 : destinations) {
					System.out.println(destination2.getCity());
				}
			} catch (DestinationDetailNotFoundException e) {
				
				System.out.println(e.getMessage());
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

