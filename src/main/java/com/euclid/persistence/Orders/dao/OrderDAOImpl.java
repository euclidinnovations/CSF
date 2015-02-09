package com.euclid.persistence.Orders.dao;

import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.euclid.persistence.Orders.model.Order;

@Repository("orderDAO")

public class OrderDAOImpl implements OrderDAO {
 @Autowired
    private SessionFactory sessionFactory;

    @Override

    public void persistOrder(Order order) {
        sessionFactory.getCurrentSession().persist(order);
    }
 

    @Override
    public Order findOrderById(String id) {
        return (Order) sessionFactory.getCurrentSession().get(Order.class, id);
    }
 

    @Override
    public void updateOrder(Order order) {
        sessionFactory.getCurrentSession().update(order);
    }

    @Override
    public void deleteOrder(Order order) {

        sessionFactory.getCurrentSession().delete(order);

    }
}