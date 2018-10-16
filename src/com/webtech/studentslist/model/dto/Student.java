package com.webtech.studentslist.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class Student implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private BigDecimal id;
	private String firstName;
	private String lastName;
	private String course;
	
	public Student(BigDecimal id, String firstName, String lastName, String course) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.course = course;
	}

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", course=" + course + "]";
	}	

}
