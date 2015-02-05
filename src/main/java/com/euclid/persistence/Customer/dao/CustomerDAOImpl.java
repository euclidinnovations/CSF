package com.euclid.persistence.Customer.dao;

import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.euclid.persistence.Customer.model.Customer;

@Repository("customerDAO")

public class CustomerDAOImpl implements CustomerDAO {
 @Autowired
    private SessionFactory sessionFactory;

    @Override

    public void persistCustomer(Customer customer) {
        sessionFactory.getCurrentSession().persist(customer);
    }
 

    @Override
    public Customer findCustomerById(String id) {
        return (Customer) sessionFactory.getCurrentSession().get(Customer.class, id);
    }
 

    @Override
    public void updateCustomer(Customer customer) {
        sessionFactory.getCurrentSession().update(customer);
    }

    @Override
    public void deleteCustomer(Customer customer) {

        sessionFactory.getCurrentSession().delete(customer);

    }
}