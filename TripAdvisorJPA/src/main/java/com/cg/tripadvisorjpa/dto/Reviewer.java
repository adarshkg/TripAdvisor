 /*	@author adgangad
 * project name: TripAdvisor
 * 			This is Reviewer dto class where data is set to each variable
 * 
*/



package com.cg.tripadvisorjpa.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reviewer")
public class Reviewer {
	@Id
	@Column(name="reviewer_id")
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Reviewer(int id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

	@Column(name="name")
	private String name;
	@Column(name="email")
	private String email;


	public Reviewer() {
		super();

	}
	public Reviewer( String name, String email) {
		super();

		this.name = name;
		this.email = email;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Reviewer [ name=" + name + ", email=" + email + "]";
	}
	
	
}
