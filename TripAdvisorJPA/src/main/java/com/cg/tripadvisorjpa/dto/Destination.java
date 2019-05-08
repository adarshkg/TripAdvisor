 /*	@author adgangad
 * project name: TripAdvisor
 * 			This is Destination dto class where data is set to each variable
 * 
*/

package com.cg.tripadvisorjpa.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name= "destination")
public class Destination {
	@Id()

	@Column(name="dest_id")
	private int id;
	
	public Destination(int id, String city, int rating, String country, List<Review> review) {
		super();
		this.id = id;
		this.city = city;
		this.rating = rating;
		this.country = country;
		this.review = review;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(unique=true,name="dest_city")
	private String city;
	@Column(name="dest_rating")
	private int rating;
	@Column(name="dest_country")
	private String country;
	
	@OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
	@JoinColumn(name="dest_id")
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
