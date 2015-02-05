package com.euclid.persistence.Customer.service;

import com.euclid.persistence.Customer.model.Customer;

public interface CustomerService {

	void persistCustomer(Customer customer);

	Customer findCustomerById(String id);

	void updateCustomer(Customer customer);

	void deleteCustomer(Customer customer);
}