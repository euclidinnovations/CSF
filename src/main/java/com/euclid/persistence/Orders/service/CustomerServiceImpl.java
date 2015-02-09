package com.euclid.persistence.Orders.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.euclid.persistence.Orders.dao.CustomerDAO;
import com.euclid.persistence.Orders.model.Customer;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public void persistCustomer(Customer customer) {
		customerDAO.persistCustomer(customer);
		
	}

	@Override
	@Transactional
	public void updateCustomer(Customer customer) {
		customerDAO.updateCustomer(customer);
		
	}
	@Override
	@Transactional
	public Customer findCustomerById(String id) {
		return customerDAO.findCustomerById(id);
	}

	@Override
	@Transactional
	public void deleteCustomer(Customer customer) {
		customerDAO.deleteCustomer(customer);
		
	}

}