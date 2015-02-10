package com.euclid.persistence.Orders.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

 

@Entity
@Table(name = "items")

public class Item {

 

    @Id
    @Column(name = "SKU", nullable = false)
    private String SKU;
    
    @Column(name = "name")
    private String itemName;
 
    @Column(name = "description")
    private String description;
     
    @Column(name = "size")
    private String size;
    
    @Column(name = "aisle")
    private String aisle;
    
    @Column(name = "unitprice")
    private String unitPrice;
 
    

	    
    public String getSKU() {
		return SKU;
	}




	public void setSKU(String SKU) {
		this.SKU = SKU;
	}




	public String getItemName() {
		return itemName;
	}




	public void setItemName(String itemName) {
		this.itemName = itemName;
	}




	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
	}




	public String getsize() {
		return size;
	}




	public void setsize(String size) {
		this.size = size;
	}




	public String getAisle() {
		return aisle;
	}




	public void setAisle(String aisle) {
		this.aisle = aisle;
	}




	public String getUnitPrice() {
		return unitPrice;
	}




	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}




	public Item() {

    }
   
}
