package com.euclid.persistence.Orders.model;


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
    private String itemOrderedSKU;
 
    @Column(name = "itemRecievedSKU")
    private String itemRecievedSKU;
     
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
