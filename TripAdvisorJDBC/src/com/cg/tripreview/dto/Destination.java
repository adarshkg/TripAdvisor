package com.cg.tripreview.dto;

import java.util.List;

public class Destination {
	private String city;
	private int rating;
	private String country;
	private List<Review> review;

	public Destination() {
		super();
	
	}
	
	public Destination(String city, int rating, String country, List<Review> reviews) {
		super();
		this.city = city;
		this.rating = rating;
		this.country = country;
		this.review = reviews;
	}

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public List<Review> getReview() {
		return review;
	}
	public void setReview(List<Review> review) {
		this.review = review;
	}

	@Override
	public String toString() {
		return "Destination [city=" + city + ", rating=" + rating + ", country=" + country + ", review=" + review + "]";
	}
	
	
	
	
}
