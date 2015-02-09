package com.euclid.persistence.Orders.dao;

import com.euclid.persistence.Orders.model.Customer;

public interface CustomerDAO {
	
		  void persistCustomer(Customer customer);
		  
		  Customer findCustomerById(String id);
		  
		  void updateCustomer(Customer customer);
		  
		  void deleteCustomer(Customer customer);

		  void deleteAll();
		  
}