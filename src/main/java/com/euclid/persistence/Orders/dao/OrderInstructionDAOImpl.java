package com.euclid.persistence.Orders.dao;

import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.euclid.persistence.Orders.model.OrderInstruction;

@Repository("orderInstructionDAO")

public class OrderInstructionDAOImpl implements OrderInstructionDAO {
 @Autowired
    private SessionFactory sessionFactory;

    @Override

    public void persistOrderInstruction(OrderInstruction orderInstruction) {
        sessionFactory.getCurrentSession().persist(orderInstruction);
    }
 

    @Override
    public OrderInstruction findOrderInstructionById(String id) {
        return (OrderInstruction) sessionFactory.getCurrentSession().get(OrderInstruction.class, id);
    }
 

    @Override
    public void updateOrderInstruction(OrderInstruction orderInstruction) {
        sessionFactory.getCurrentSession().update(orderInstruction);
    }

    @Override
    public void deleteOrderInstruction(OrderInstruction orderInstruction) {

        sessionFactory.getCurrentSession().delete(orderInstruction);

    }
}