package com.euclid.persistence.Orders.service;

import com.euclid.persistence.Orders.model.Customer;

public interface CustomerService {

	void persistCustomer(Customer customer);

	Customer findCustomerById(String id);

	void updateCustomer(Customer customer);

	void deleteCustomer(Customer customer);
	
	void deleteAll();
	
	Boolean exists(String id);
}