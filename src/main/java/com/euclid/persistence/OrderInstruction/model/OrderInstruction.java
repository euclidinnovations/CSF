package com.euclid.persistence.OrderInstruction.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

 

@Entity
@Table(name = "orderinstructions")

public class OrderInstruction {

 

    @Id
    @Column(name = "orderId", nullable = false)
    private int orderId;
    
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
 
    
    public int getOrderId() {
		return orderId;
	}


	public void setOrderId(int orderId) {
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
