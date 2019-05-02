package com.cg.tripreview.dto;

public class Reviewer {
	private String name;
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
