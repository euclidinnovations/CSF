package com.euclid.persistence.Orders.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

 

@Entity
@Table(name = "orders")

public class Order {

 

    @Id
    @Column(name = "orderId", nullable = false)
    private String orderId;
    
    @Column(name = "customerId")
    private String customerId;
 
    @Column(name = "pickup")
    private String pickup;
     
 	    
    public String getOrderId() {
		return orderId;
	}


	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}


	public String getCustomerId() {
		return customerId;
	}


	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}


	public String getPickup() {
		return pickup;
	}


	public void setPickup(String pickup) {
		this.pickup = pickup;
	}


	public Order() {

    }
   
}
