package com.euclid.persistence.Orders.dao;

import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.euclid.persistence.Orders.model.CSF;

@Repository("csfDAO")

public class CSFDAOImpl implements CSFDAO {
 @Autowired
    private SessionFactory sessionFactory;

    @Override

    public void persistCSF(CSF csf) {
        sessionFactory.getCurrentSession().persist(csf);
    }
 

    @Override
    public CSF findCSFById(String id) {
        return (CSF) sessionFactory.getCurrentSession().get(CSF.class, id);
    }
 

    @Override
    public void updateCSF(CSF csf) {
        sessionFactory.getCurrentSession().update(csf);
    }

    @Override
    public void deleteCSF(CSF csf) {

        sessionFactory.getCurrentSession().delete(csf);

    }
}