package com.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Teacher")
public class Teacher {

    @Id
    @Column(name="id", nullable = false)
	private int id;
    
    @Column(name="firstName", nullable = false)
	private String firstName;
    
    @Column(name="lastName", nullable = false)
	private String lastName;
    
    @Column(name="dateOfBirth", nullable = false)
	private String dateOfBirth;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String fistName) {
		this.firstName = fistName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
