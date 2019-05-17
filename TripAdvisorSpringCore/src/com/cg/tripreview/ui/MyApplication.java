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


package com.cg.tripreview.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import com.cg.tripreview.configure.JavaConfig;
import com.cg.tripreview.dto.Destination;
import com.cg.tripreview.dto.Review;
import com.cg.tripreview.dto.Reviewer;
import com.cg.tripreview.exceptions.DestinationDetailNotFoundException;
import com.cg.tripreview.service.DestinationServiceImp;
import com.cg.tripreview.service.ReviewServiceImp;


@Component
public class MyApplication {
	
	private static ReviewServiceImp reviewServiceStatic;
	private static DestinationServiceImp destinationServiceStatic;
		
	@Autowired
	ReviewServiceImp reviewService;
	
	@Autowired
    DestinationServiceImp destinationService;
	
	@PostConstruct
    private void init(){
		MyApplication.reviewServiceStatic =reviewService;
		MyApplication.destinationServiceStatic = destinationService;
    }
	
/**	main class starts here where get data from users and and send to the service layer */
	
	public static void main(String[] args) {
		/**
		 * Create a new AnnotationConfigApplicationContext and passing JavaConfig Class */
		
		AnnotationConfigApplicationContext app =new AnnotationConfigApplicationContext(JavaConfig.class);
		
		int choice =0;
		Scanner scan = new Scanner(System.in);
		do {
		System.out.println("1. Add Destination \n2. Add Review \n3. Search Review By city\n"
				+ "4.Search Destination By rating\n5. Exit");
		System.out.println("Enter choice");
		choice = scan.nextInt();
		switch (choice) {
		
/**		Getting destination details from the user and sending to service layer */
		case 1:
			System.out.println("********Add Destination*********");
			try {
			List <Review> reviews = new ArrayList<>();
			System.out.println("Enter city");
			String city =scan.next();
			System.out.println("Enter country");
			String country = scan.next();
			System.out.println("Enter rating");
			int rating = scan.nextInt();	
			
			Destination destination=(Destination) app.getBean("destination");
			destination.setCity(city);
			destination.setRating(rating);
			destination.setCountry(country);
			destination.setReview(reviews);
			
			destinationServiceStatic.addDestination(destination);
			
			
			} catch (DestinationDetailNotFoundException e1) {
				System.out.println(e1.getMessage());
			}
			break;
			
/**			Getting review details from the user and sending to service layer */
			
		case 2:
			System.out.println("********Add Review********");
			scan.nextLine(); 
			System.out.println("Enter review Destination");
			String dest =scan.next();
			
			System.out.println("Enter review ID");
			int Id =scan.nextInt();
			scan.nextLine();
			
			System.out.println("Enter review");
			String description = scan.nextLine();
			
			
			System.out.println("Enter reviewer Id");
			int reviwerId =scan.nextInt();
			
			System.out.println("Enter reviewer Name");
			String reviewerName =scan.next();
			
			System.out.println("Enter reviewer Email");
			String reviewerEmail =scan.next();
			
			try {
				
				Review review = (Review) app.getBean("review");	
				Reviewer reviewer = (Reviewer) app.getBean("reviewer");
				
				
				reviewer.setId(reviwerId);
				reviewer.setName(reviewerName);
				reviewer.setEmail(reviewerEmail);
				
				review.setId(Id);
				review.setCity(dest);
				review.setDescription(description);

				reviewServiceStatic.addReview(review);

			} catch (DestinationDetailNotFoundException e) {
				System.out.println(e.getMessage());
			}
			
			break;
			
/**		Getting destination from the user and fetching the reviews from the service layer */

		case 3:
			System.out.println("********Search Review by City********");
			scan.nextLine();
			System.out.println("Enter destination name: ");
			String myDestination=scan.nextLine();
	
			try {
				List<Review> reviews = destinationServiceStatic.SearchReviewByDestination(myDestination);
				for (Review review : reviews) {
					System.out.println(review.getDescription());
				}
				
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
				destinations = destinationServiceStatic.SearchDestinationByRating(destinationRating);
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

