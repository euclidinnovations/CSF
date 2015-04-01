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
    private String productTotal;
 
    @Column(name = "taxTotal")
    private String taxTotal;
     
    @Column(name = "serviceFee")
    private String serviceFee;
    
    @Column(name = "additionalCharges")
    private String additionalCharges;
    
    @Column(name = "deposit")
    private String deposit;
    
    @Column(name = "discount")
    private String discount;
    
    @Column(name = "specialPromotions")
    private String specialPromotions;
    
    @Column(name = "orderTotal")
    private String orderTotal;
    
    
    
    public String getOrderId() {
		return orderId;
	}



	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}



	public String getProductTotal() {
		return productTotal;
	}



	public void setProductTotal(String productTotal) {
		this.productTotal = productTotal;
	}



	public String getTaxTotal() {
		return taxTotal;
	}



	public void setTaxTotal(String taxTotal) {
		this.taxTotal = taxTotal;
	}



	public String getServiceFee() {
		return serviceFee;
	}



	public void setServiceFee(String serviceFee) {
		this.serviceFee = serviceFee;
	}



	public String getAdditionalCharges() {
		return additionalCharges;
	}



	public void setAdditionalCharges(String addcharges) {
		this.additionalCharges = addcharges;
	}



	public String getDeposit() {
		return deposit;
	}



	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}



	public String getDiscount() {
		return discount;
	}



	public void setDiscount(String discount) {
		this.discount = discount;
	}



	public String getSpecialPromotions() {
		return specialPromotions;
	}



	public void setSpecialPromotions(String specialPromotions) {
		this.specialPromotions = specialPromotions;
	}



	public String getOrderTotal() {
		return orderTotal;
	}



	public void setOrderTotal(String orderTotal) {
		this.orderTotal = orderTotal;
	}



	public OrderTotal() {

    }
   
}
