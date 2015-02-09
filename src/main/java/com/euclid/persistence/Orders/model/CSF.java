package com.euclid.persistence.Orders.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

 

@Entity
@Table(name = "csfs")

public class CSF {

 

    @Id
    @Column(name = "csfId", nullable = false)
    private String csfId;
    
    @Column(name = "orderId")
    private String orderId;
    
    @Column(name = "firstName")
    private String firstName;
 
    @Column(name = "lastName")
    private String lastName;
     
    @Column(name = "phone")
    private String phone;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "address")
    private String address;
 
    @Column(name = "specialInstructions")
    private String specialInstructions;

    @Column(name = "paymentType")
    private String paymentType;
 
    @Column(name = "itemOrdered")
    private String itemOrdered;

    @Column(name = "itemRecieved")
    private String itemRecieved;
    

	    
    public String getOrderId() {
		return orderId;
	}



	public void setOrderId(String orderId) {
		this.orderId = orderId;
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



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
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



	public String getSpecialInstructions() {
		return specialInstructions;
	}



	public void setSpecialInstructions(String specialInstructions) {
		this.specialInstructions = specialInstructions;
	}



	public String getPaymentType() {
		return paymentType;
	}



	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}



	public String getItemOrdered() {
		return itemOrdered;
	}



	public void setItemOrdered(String itemOrdered) {
		this.itemOrdered = itemOrdered;
	}



	public String getItemRecieved() {
		return itemRecieved;
	}



	public void setItemRecieved(String itemRecieved) {
		this.itemRecieved = itemRecieved;
	}



	public CSF() {

    }
   
}
