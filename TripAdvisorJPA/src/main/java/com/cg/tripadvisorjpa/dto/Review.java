 /*	@author adgangad
 * project name: TripAdvisor
 * 			This is Review dto class where data is set to each variable
 * 
*/


package com.cg.tripadvisorjpa.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="review")
public class Review {
	@Id
	@Column(name="review_id")
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="review_desc")
	private String description;
	@OneToOne()
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
