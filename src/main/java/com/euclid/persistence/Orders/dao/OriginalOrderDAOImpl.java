package com.euclid.persistence.Orders.dao;

import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.euclid.persistence.Orders.model.OriginalOrder;

@Repository("originalOrderDAO")

public class OriginalOrderDAOImpl implements OriginalOrderDAO {
 @Autowired
    private SessionFactory sessionFactory;

    @Override

    public void persistOriginalOrder(OriginalOrder originalOrder) {
        sessionFactory.getCurrentSession().persist(originalOrder);
    }
 

    @Override
    public OriginalOrder findOriginalOrderById(String id) {
        return (OriginalOrder) sessionFactory.getCurrentSession().get(OriginalOrder.class, id);
    }
 

    @Override
    public void updateOriginalOrder(OriginalOrder originalOrder) {
        sessionFactory.getCurrentSession().update(originalOrder);
    }

    @Override
    public void deleteOriginalOrder(OriginalOrder originalOrder) {

        sessionFactory.getCurrentSession().delete(originalOrder);

    }
}