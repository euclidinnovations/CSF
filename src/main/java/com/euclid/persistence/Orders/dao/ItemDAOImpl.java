package com.euclid.persistence.Orders.dao;

import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.euclid.persistence.Orders.model.Item;

@Repository("itemDAO")

public class ItemDAOImpl implements ItemDAO {
 @Autowired
    private SessionFactory sessionFactory;

    @Override

    public void persistItem(Item item) {
        sessionFactory.getCurrentSession().persist(item);
    }
 

    @Override
    public Item findItemById(String id) {
        return (Item) sessionFactory.getCurrentSession().get(Item.class, id);
    }
 

    @Override
    public void updateItem(Item item) {
        sessionFactory.getCurrentSession().update(item);
    }

    @Override
    public void deleteItem(Item item) {

        sessionFactory.getCurrentSession().delete(item);

    }
}