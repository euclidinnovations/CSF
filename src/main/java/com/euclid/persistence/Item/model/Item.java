package com.euclid.persistence.Item.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

 

@Entity
@Table(name = "items")

public class Item {

 

    @Id
    @Column(name = "SKU", nullable = false)
    private double SKU;
    
    @Column(name = "name")
    private String itemName;
 
    @Column(name = "description")
    private String description;
     
    @Column(name = "size")
    private String phone;
    
    @Column(name = "aisle")
    private String aisle;
    
    @Column(name = "unitprice")
    private float unitPrice;
 
    

	    
    public double getSKU() {
		return SKU;
	}




	public void setSKU(double sKU) {
		SKU = sKU;
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




	public String getPhone() {
		return phone;
	}




	public void setPhone(String phone) {
		this.phone = phone;
	}




	public String getAisle() {
		return aisle;
	}




	public void setAisle(String aisle) {
		this.aisle = aisle;
	}




	public float getUnitPrice() {
		return unitPrice;
	}




	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}




	public Item() {

    }
   
}
