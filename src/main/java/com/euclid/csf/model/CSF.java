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
	
	private String personalShopper;
	
	private String deliveryPerson;
	
	private String RX;
	
	private String callNotes;
	
	private String customerCalled;
	
	private String checkID;
	
	private String couponsRedeemed;
	
	private String received;
	
	private String bulkItems;
	
	private String dryGoods;
	
	private String perishables;
	
	private String frozen;
	
	private String hot;
	
	private String floral;
	
	private String dryGoodsSection;
	
	private String perishablesSection;
	
	private String frozenSection;
	
	private String hotSection;
	
	private String floralSection;
	
	private String dob;
	
	/**
	 * @return the dob
	 */
	public String getDob() {
		return dob;
	}

	/**
	 * @param dob the dob to set
	 */
	public void setDob(String dob) {
		this.dob = dob;
	}

	private HashMap<String,String> modSavedMap = new HashMap<String,String>(); 
	
	/**
	 * @return the dryGoodsSection
	 */
	public String getDryGoodsSection() {
		return dryGoodsSection;
	}

	/**
	 * @param dryGoodsSection the dryGoodsSection to set
	 */
	public void setDryGoodsSection(String dryGoodsSection) {
		this.dryGoodsSection = dryGoodsSection;
	}

	/**
	 * @return the perishablesSection
	 */
	public String getPerishablesSection() {
		return perishablesSection;
	}

	/**
	 * @param perishablesSection the perishablesSection to set
	 */
	public void setPerishablesSection(String perishablesSection) {
		this.perishablesSection = perishablesSection;
	}

	/**
	 * @return the frozenSection
	 */
	public String getFrozenSection() {
		return frozenSection;
	}

	/**
	 * @param frozenSection the frozenSection to set
	 */
	public void setFrozenSection(String frozenSection) {
		this.frozenSection = frozenSection;
	}

	/**
	 * @return the hotSection
	 */
	public String getHotSection() {
		return hotSection;
	}

	/**
	 * @param hotSection the hotSection to set
	 */
	public void setHotSection(String hotSection) {
		this.hotSection = hotSection;
	}

	/**
	 * @return the floralSection
	 */
	public String getFloralSection() {
		return floralSection;
	}

	/**
	 * @param floralSection the floralSection to set
	 */
	public void setFloralSection(String floralSection) {
		this.floralSection = floralSection;
	}

	public HashMap<String, String> getModSavedMap() {
		return modSavedMap;
	}

	public void setModSavedMap(HashMap<String, String> modSavedMap) {
		this.modSavedMap = modSavedMap;
	}

	/**
	 * @return the personalShopper
	 */
	public String getPersonalShopper() {
		return personalShopper;
	}

	/**
	 * @param personalShopper the personalShopper to set
	 */
	public void setPersonalShopper(String personalShopper) {
		this.personalShopper = personalShopper;
	}

	/**
	 * @return the deliveryPerson
	 */
	public String getDeliveryPerson() {
		return deliveryPerson;
	}

	/**
	 * @param deliveryPerson the deliveryPerson to set
	 */
	public void setDeliveryPerson(String deliveryPerson) {
		this.deliveryPerson = deliveryPerson;
	}

	/**
	 * @return the rX
	 */
	public String getRX() {
		return RX;
	}

	/**
	 * @param rX the rX to set
	 */
	public void setRX(String rX) {
		RX = rX;
	}

	/**
	 * @return the callNotes
	 */
	public String getCallNotes() {
		return callNotes;
	}

	/**
	 * @param callNotes the callNotes to set
	 */
	public void setCallNotes(String callNotes) {
		this.callNotes = callNotes;
	}

	/**
	 * @return the customerCalled
	 */
	public String getCustomerCalled() {
		return customerCalled;
	}

	/**
	 * @param customerCalled the customerCalled to set
	 */
	public void setCustomerCalled(String customerCalled) {
		this.customerCalled = customerCalled;
	}

	/**
	 * @return the checkID
	 */
	public String getCheckID() {
		return checkID;
	}

	/**
	 * @param checkID the checkID to set
	 */
	public void setCheckID(String checkID) {
		this.checkID = checkID;
	}

	/**
	 * @return the couponsRedeemed
	 */
	public String getCouponsRedeemed() {
		return couponsRedeemed;
	}

	/**
	 * @param couponsRedeemed the couponsRedeemed to set
	 */
	public void setCouponsRedeemed(String couponsRedeemed) {
		this.couponsRedeemed = couponsRedeemed;
	}

	/**
	 * @return the received
	 */
	public String getReceived() {
		return received;
	}

	/**
	 * @param received the received to set
	 */
	public void setReceived(String received) {
		this.received = received;
	}

	/**
	 * @return the bulkItems
	 */
	public String getBulkItems() {
		return bulkItems;
	}

	/**
	 * @param bulkItems the bulkItems to set
	 */
	public void setBulkItems(String bulkItems) {
		this.bulkItems = bulkItems;
	}

	/**
	 * @return the dryGoods
	 */
	public String getDryGoods() {
		return dryGoods;
	}

	/**
	 * @param dryGoods the dryGoods to set
	 */
	public void setDryGoods(String dryGoods) {
		this.dryGoods = dryGoods;
	}

	/**
	 * @return the perishables
	 */
	public String getPerishables() {
		return perishables;
	}

	/**
	 * @param perishables the perishables to set
	 */
	public void setPerishables(String perishables) {
		this.perishables = perishables;
	}

	/**
	 * @return the frozen
	 */
	public String getFrozen() {
		return frozen;
	}

	/**
	 * @param frozen the frozen to set
	 */
	public void setFrozen(String frozen) {
		this.frozen = frozen;
	}

	/**
	 * @return the hot
	 */
	public String getHot() {
		return hot;
	}

	/**
	 * @param hot the hot to set
	 */
	public void setHot(String hot) {
		this.hot = hot;
	}

	/**
	 * @return the floral
	 */
	public String getFloral() {
		return floral;
	}

	/**
	 * @param floral the floral to set
	 */
	public void setFloral(String floral) {
		this.floral = floral;
	}

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