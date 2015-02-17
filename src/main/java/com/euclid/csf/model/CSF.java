package com.euclid.csf.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
	
	private Map<String, ArrayList<String>> modifiedItemsMap = new HashMap<String, ArrayList<String>>();
	
	private List<String> lookupItems= new ArrayList<String>();
	
	private String orderTotal;
	
	private String pickup;
	
	private String substitutionPolicy;
	
	private String vic;
	
	private String vicSavings;
	
	public String getVicSavings() {
		return vicSavings;
	}

	public void setVicSavings(String vicSavings) {
		this.vicSavings = vicSavings;
	}

	public String getVic() {
		return vic;
	}

	public void setVic(String vic) {
		this.vic = vic;
	}

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

	public void setAddress(String address) {
		this.address=address;
	}
	
	public String getAddress() {
		return address;
	}

	public List<String> getLookupItems() {
		return lookupItems;
	}

	public void setLookupItems(List<String> lookupItems) {
		this.lookupItems = lookupItems;
	}
	
	public Map<String, ArrayList<String>> getModifiedItemsMap() {
		return modifiedItemsMap;
	}

	public void setModifiedItemsMap(Map<String, ArrayList<String>> modifiedItemsMap) {
		this.modifiedItemsMap = modifiedItemsMap;
	}

	public String getSubstitutionPolicy() {
		return substitutionPolicy;
	}

	public void setSubstitutionPolicy(String substitutionPolicy) {
		this.substitutionPolicy = substitutionPolicy;
	}
	
}