package com.cg.tripreview.dto;

public class Review {

	
	private String description;
	private Reviewer reviewer;

	public Review(String description, Reviewer reviewer) {
		super();

	
		this.description = description;
		this.reviewer = reviewer;
	}
	public Review() {
		super();

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
		return "Review [ description=" + description + ", reviewer=" + reviewer + "]";
	}

}
