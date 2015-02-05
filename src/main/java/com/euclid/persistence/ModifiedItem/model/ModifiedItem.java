package com.euclid.persistence.ModifiedItem.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

 

@Entity
@Table(name = "modifieditems")

public class ModifiedItem {

 

    @Id
    @Column(name = "orderId", nullable = false)
    private int orderId;
    
    @Column(name = "itemOrderedSKU")
    private double itemOrderedSKU;
 
    @Column(name = "itemRecievedSKU")
    private double itemRecievedSKU;
     
    @Column(name = "itemOrderedQty")
    private int itemOrderedQty;
    
    @Column(name = "itemRecievedQty")
    private int itemRecievedQty;
    
    @Column(name = "itemOrderedSize")
    private String itemOrderedSize;
    
    @Column(name = "itemRecievedSize")
    private String itemRecievedSize;
 
    

	    
    public int getOrderId() {
		return orderId;
	}




	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}




	public double getItemOrderedSKU() {
		return itemOrderedSKU;
	}




	public void setItemOrderedSKU(double itemOrderedSKU) {
		this.itemOrderedSKU = itemOrderedSKU;
	}




	public double getItemRecievedSKU() {
		return itemRecievedSKU;
	}




	public void setItemRecievedSKU(double itemRecievedSKU) {
		this.itemRecievedSKU = itemRecievedSKU;
	}




	public int getItemOrderedQty() {
		return itemOrderedQty;
	}




	public void setItemOrderedQty(int itemOrderedQty) {
		this.itemOrderedQty = itemOrderedQty;
	}




	public int getItemRecievedQty() {
		return itemRecievedQty;
	}




	public void setItemRecievedQty(int itemRecievedQty) {
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




	public ModifiedItem() {

    }
   
}
