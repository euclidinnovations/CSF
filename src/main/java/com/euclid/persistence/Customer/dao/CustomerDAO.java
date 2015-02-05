package com.euclid.persistence.Customer.dao;

import com.euclid.persistence.Customer.model.Customer;

public interface CustomerDAO {
	
		  void persistCustomer(Customer customer);
		  
		  Customer findCustomerById(String id);
		  
		  void updateCustomer(Customer customer);
		  
		  void deleteCustomer(Customer customer);
		  
}