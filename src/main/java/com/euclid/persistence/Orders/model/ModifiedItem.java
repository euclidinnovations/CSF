package com.euclid.persistence.Orders.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

 

@Entity
@Table(name = "modifieditems")

public class ModifiedItem {

 
	
    @Id
    @Column(name = "modId", nullable = false)
    private String modId;
	
    @Column(name = "orderId")
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
    
   	@Column(name = "itemOrderedName")
    private String itemOrderedName;
    
    
	@Column(name = "itemRecievedName")
    private String itemRecievedName;
 
    
	 public String getModId() {
		return modId;
	}




	public void setModId(String modId) {
		this.modId = modId;
	}




	public String getItemRecievedName() {
			return itemRecievedName;
		}




		public void setItemRecievedName(String itemRecievedName) {
			this.itemRecievedName = itemRecievedName;
		}
		
		public String getItemOrderedName() {
			return itemOrderedName;
		}




		public void setItemOrderedName(String itemOrderedName) {
			this.itemOrderedName = itemOrderedName;
		}

	    
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




	public ModifiedItem() {

    }
   
}
