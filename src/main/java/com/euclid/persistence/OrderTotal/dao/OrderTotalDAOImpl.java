package com.euclid.persistence.OrderTotal.dao;

import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.euclid.persistence.OrderTotal.model.OrderTotal;

@Repository("orderTotalDAO")

public class OrderTotalDAOImpl implements OrderTotalDAO {
 @Autowired
    private SessionFactory sessionFactory;

    @Override

    public void persistOrderTotal(OrderTotal orderTotal) {
        sessionFactory.getCurrentSession().persist(orderTotal);
    }
 

    @Override
    public OrderTotal findOrderTotalById(String id) {
        return (OrderTotal) sessionFactory.getCurrentSession().get(OrderTotal.class, id);
    }
 

    @Override
    public void updateOrderTotal(OrderTotal orderTotal) {
        sessionFactory.getCurrentSession().update(orderTotal);
    }

    @Override
    public void deleteOrderTotal(OrderTotal orderTotal) {

        sessionFactory.getCurrentSession().delete(orderTotal);

    }
}