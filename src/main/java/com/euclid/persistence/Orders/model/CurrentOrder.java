package com.euclid.persistence.Orders.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

 

@Entity
@Table(name = "currentorder")

public class CurrentOrder {

 

    @Id
    @Column(name = "orderId", nullable = false)
    private String orderId;
    
    @Column(name = "itemOrderedSKU")
    private String itemOrderedSKU;
 
    @Column(name = "itemRecievedSKU")
    private String itemRecievedSKU;
     
    @Column(name = "itemOrderedQty")
    private String itemOrderedQty;
    
    @Column(name = "itemRecievedQty")
    private String itemRecievedQty;
    
    @Column(name = "itemOrderedSize")
    private String itemOrderedSize;
    
    @Column(name = "itemRecievedSize")
    private String itemRecievedSize;
 
    

	    
    public String getOrderId() {
		return orderId;
	}




	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}




	public String getItemOrderedSKU() {
		return itemOrderedSKU;
	}




	public void setItemOrderedSKU(String itemOrderedSKU) {
		this.itemOrderedSKU = itemOrderedSKU;
	}




	public String getItemRecievedSKU() {
		return itemRecievedSKU;
	}




	public void setItemRecievedSKU(String itemRecievedSKU) {
		this.itemRecievedSKU = itemRecievedSKU;
	}




	public String getItemOrderedQty() {
		return itemOrderedQty;
	}




	public void setItemOrderedQty(String itemOrderedQty) {
		this.itemOrderedQty = itemOrderedQty;
	}




	public String getItemRecievedQty() {
		return itemRecievedQty;
	}




	public void setItemRecievedQty(String itemRecievedQty) {
		this.itemRecievedQty = itemRecievedQty;
	}




	public String getItemOrderedSize() {
		return itemOrderedSize;
	}




	public void setItemOrderedSize(String itemOrderedSize) {
		this.itemOrderedSize = itemOrderedSize;
	}




	public String getItemRecievedSize() {
		return itemRecievedSize;
	}




	public void setItemRecievedSize(String itemRecievedSize) {
		this.itemRecievedSize = itemRecievedSize;
	}




	public CurrentOrder() {

    }
   
}
