package com.euclid.persistence.Orders.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

 

@Entity
@Table(name = "ordertotals")

public class OrderTotal {

 

    @Id
    @Column(name = "orderId", nullable = false)
    private String orderId;
    
    @Column(name = "productTotal")
    private float productTotal;
 
    @Column(name = "taxTotal")
    private float taxTotal;
     
    @Column(name = "serviceFee")
    private float serviceFee;
    
    @Column(name = "additionalCharges")
    private float additionalCharges;
    
    @Column(name = "deposit")
    private float deposit;
    
    @Column(name = "discount")
    private float discount;
    
    @Column(name = "specialPromotions")
    private float specialPromotions;
    
    @Column(name = "orderTotal")
    private float orderTotal;
    
    
    
    public String getOrderId() {
		return orderId;
	}



	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}



	public Float getProductTotal() {
		return productTotal;
	}



	public void setProductTotal(Float productTotal) {
		this.productTotal = productTotal;
	}



	public Float getTaxTotal() {
		return taxTotal;
	}



	public void setTaxTotal(Float taxTotal) {
		this.taxTotal = taxTotal;
	}



	public Float getServiceFee() {
		return serviceFee;
	}



	public void setServiceFee(Float serviceFee) {
		this.serviceFee = serviceFee;
	}



	public Float getAdditionalCharges() {
		return additionalCharges;
	}



	public void setAdditionalCharges(Float additionalCharges) {
		this.additionalCharges = additionalCharges;
	}



	public Float getDeposit() {
		return deposit;
	}



	public void setDeposit(Float deposit) {
		this.deposit = deposit;
	}



	public Float getDiscount() {
		return discount;
	}



	public void setDiscount(Float discount) {
		this.discount = discount;
	}



	public Float getSpecialPromotions() {
		return specialPromotions;
	}



	public void setSpecialPromotions(Float specialPromotions) {
		this.specialPromotions = specialPromotions;
	}



	public Float getOrderTotal() {
		return orderTotal;
	}



	public void setOrderTotal(Float orderTotal) {
		this.orderTotal = orderTotal;
	}



	public OrderTotal() {

    }
   
}
