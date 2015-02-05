package com.euclid.persistence.Customer.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

 

@Entity
@Table(name = "customers")

public class Customer {

 

    @Id
    @Column(name = "customerId", nullable = false)
    private String customerId;
    
    @Column(name = "firstName")
    private String firstName;
 
    @Column(name = "lastName")
    private String lastName;
     
    @Column(name = "phone")
    private double phone;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "address")
    private String address;
 
    public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
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

	public double getPhone() {
		return phone;
	}

	public void setPhone(double phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	    
    public Customer() {

    }
   
}
