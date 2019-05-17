/*
 *	@author adgangad
 * project name: TripAdvisor
 * 			This project is about adding destination and writing  review for the destination
 * 
 */
package com.cg.tripreview.dto;

import org.springframework.stereotype.Component;

@Component
public class Reviewer {
	private int id;
	private String name;
	private String email;
	public int getId() {
		return id;
	}

	public Reviewer() {
		super();

	}
	public Reviewer(int id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}
	public void setId(int id) {
		this.id = id;
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
		return "Reviewer [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
	
	
}
