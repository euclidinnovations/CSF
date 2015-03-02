package com.euclid.persistence.Orders.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

 

@Entity
@Table(name = "csf")

public class CSFSave {

 

    @Id
    @Column(name = "orderId", nullable = false)
    private String orderId;
    
    @Column(name = "personalShopper")
    private String personalShopper;
 
    @Column(name = "deliveryPerson")
    private String deliveryPerson;
     
    @Column(name = "RX")
    private String RX;
    
    @Column(name = "customerCalled")
    private String customerCalled;
    
    @Column(name = "checkID")
    private String checkID;
    
    @Column(name = "callNotes")
    private String callNotes;
    
    @Column(name = "couponsRedeemed")
    private String couponsRedeemed;
 
    @Column(name = "received")
    private String received;
     
    @Column(name = "bulkItems")
    private String bulkItems;
    
    @Column(name = "dryGoodsSection")
    private String dryGoodsSection;
    
    @Column(name = "perishablesSection")
    private String perishablesSection;
    
    @Column(name = "frozenSection")
    private String frozenSection;
    
    @Column(name = "hotSection")
    private String hotSection;
    
    @Column(name = "floralSection")
    private String floralSection;
    
    @Column(name = "dryGoods")
    private String dryGoods;
    
    @Column(name = "perishables")
    private String perishables;
    
    @Column(name = "frozen")
    private String frozen;
    
    @Column(name = "hot")
    private String hot;
    
    @Column(name = "floral")
    private String floral;
    
    @Column(name = "dob")
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

	/**
	 * @return the orderId
	 */
	public String getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
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

	public CSFSave() {

    }

	
   
}
