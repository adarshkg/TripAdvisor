package com.cg.tripreview.dto;

public class Review {

	private  int id;
	private String city;
	private String description;
	private Reviewer reviewer;
	
	public Review(int id,String city, String description, Reviewer reviewer) {
		super();
		this.id = id;
		this.city = city;
		this.description = description;
		this.reviewer = reviewer;
	}
	public Review() {
		super();

	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Reviewer getReviewer() {
		return reviewer;
	}
	public void setReviewer(Reviewer reviewer) {
		this.reviewer = reviewer;
	}
	@Override
	public String toString() {
		return "Review [id=" + id + ", city=" + city + ", description=" + description + ", reviewer=" + reviewer + "]";
	}

}
