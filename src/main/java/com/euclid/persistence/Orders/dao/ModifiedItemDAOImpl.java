package com.euclid.persistence.Orders.dao;

import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.euclid.persistence.Orders.model.ModifiedItem;

@Repository("modifiedItemDAO")

public class ModifiedItemDAOImpl implements ModifiedItemDAO {
 @Autowired
    private SessionFactory sessionFactory;

    @Override

    public void persistModifiedItem(ModifiedItem modifiedItem) {
        sessionFactory.getCurrentSession().persist(modifiedItem);
    }
 

    @Override
    public ModifiedItem findModifiedItemById(String id) {
        return (ModifiedItem) sessionFactory.getCurrentSession().get(ModifiedItem.class, id);
    }
 

    @Override
    public void updateModifiedItem(ModifiedItem modifiedItem) {
        sessionFactory.getCurrentSession().update(modifiedItem);
    }

    @Override
    public void deleteModifiedItem(ModifiedItem modifiedItem) {

        sessionFactory.getCurrentSession().delete(modifiedItem);

    }
}