package com.euclid.persistence.Orders.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

 

@Entity
@Table(name = "orderinstructions")

public class OrderInstruction {

 

    @Id
    @Column(name = "orderId", nullable = false)
    private String orderId;
    
    @Column(name = "substitution")
    private String substitution;
 
    @Column(name = "specialInstructions")
    private String specialInstructions;
     
    @Column(name = "paymentMethod")
    private String paymentMethod;
    
    @Column(name = "totesUsed")
    private String totesUsed;
    
    @Column(name = "promotionCode")
    private String promotionCode;
 
    @Column(name = "vicSavings")
    private String vicSavings;
    
    public String getVicSavings() {
		return vicSavings;
	}


	public void setVicSavings(String vicSavings) {
		this.vicSavings = vicSavings;
	}


	public String getOrderId() {
		return orderId;
	}


	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}


	public String getSubstitution() {
		return substitution;
	}


	public void setSubstitution(String substitution) {
		this.substitution = substitution;
	}


	public String getSpecialInstructions() {
		return specialInstructions;
	}


	public void setSpecialInstructions(String specialInstructions) {
		this.specialInstructions = specialInstructions;
	}


	public String getPaymentMethod() {
		return paymentMethod;
	}


	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}


	public String getTotesUsed() {
		return totesUsed;
	}


	public void setTotesUsed(String totesUsed) {
		this.totesUsed = totesUsed;
	}


	public String getPromotionCode() {
		return promotionCode;
	}


	public void setPromotionCode(String promotionCode) {
		this.promotionCode = promotionCode;
	}


	public OrderInstruction() {

    }
   
}
