package com.euclid.persistence.OriginalOrder.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

 

@Entity
@Table(name = "originalorder")

public class OriginalOrder {

 

    @Id
    @Column(name = "orderId", nullable = false)
    private int orderId;
    
    @Column(name = "SKU")
    private double SKU;
 
    @Column(name = "Qty")
    private int qty;
     
    @Column(name = "size")
    private String size;
    
    
	    
    public int getOrderId() {
		return orderId;
	}



	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}



	public double getSKU() {
		return SKU;
	}



	public void setSKU(double sKU) {
		SKU = sKU;
	}



	public int getQty() {
		return qty;
	}



	public void setQty(int qty) {
		this.qty = qty;
	}



	public String getSize() {
		return size;
	}



	public void setSize(String size) {
		this.size = size;
	}



	public OriginalOrder() {

    }
   
}
