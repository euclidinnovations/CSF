package com.euclid.persistence.Orders.dao;

import java.util.List;

import org.hibernate.Query;
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


	@Override
	public boolean exists(String orderID, String sku) {
		Query query = sessionFactory.getCurrentSession().             
	    	    createQuery("select 1 from OriginalOrder t where t.orderId = :key and t.SKU = :key2");
	    	        query.setString("key", orderID );
	    	        query.setString("key2", sku);
	    	    return (query.uniqueResult() != null);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<String> getAllOriginalItemSKUs(String orderID) {
		Query query = sessionFactory.getCurrentSession().             
	    	    createQuery("select o.SKU from OriginalOrder o where o.orderId = :key");
	    	        query.setParameter("key", orderID);
	    	        
	    	        List<String> origItems = query.list();
		return origItems;
	}
}