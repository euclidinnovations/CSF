package com.euclid.csf.model;

import java.util.List;


public class CSF{
	private String orderId;
	
	private String customerId;
	
	private String firstName;
	
	private String lastName;
	
	private String phone;
	
	private String address;	

	private String email;
	
	private String specialInstructions;
	
	private String paymentType;
	
	private List<String> itemOrdered;
	
	private List<String> itemsRecieved;
	
	private String orderTotal;
	
	private String pickup;
	
	public String getPickup() {
		return pickup;
	}

	public void setPickup(String pickup) {
		this.pickup = pickup;
	}

	public String getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(String orderTotal) {
		this.orderTotal = orderTotal;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

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

	public List<String> getItemOrdered() {
		return itemOrdered;
	}

	public void setItemOrdered(List<String> itemOrdered) {
		this.itemOrdered = itemOrdered;
	}

	public List<String> getItemsRecieved() {
		return itemsRecieved;
	}

	public void setItemsRecieved(List<String> itemsRecieved) {
		this.itemsRecieved = itemsRecieved;
	}

	public void setAddress(String address) {
		this.address=address;
	}
	
	public String getAddress() {
		return address;
	}
	
	
}