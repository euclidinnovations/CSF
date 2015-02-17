package com.euclid.persistence.Orders.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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
    
    @Override
    public List<Object[]> getLookupItems(String orderId){
    			
		Query query = sessionFactory.getCurrentSession().
				createQuery("select c.itemOrderedName,c.itemRecievedName from ModifiedItem c WHERE c.orderId=:key");
				query.setString("key", orderId);
		List<Object[]> rows = query.list();
		return rows;
    }


	@Override
	public boolean exists(String orderID, String productSKU) {
		Query query = sessionFactory.getCurrentSession().             
	    	    createQuery("select 1 from ModifiedItem t where t.orderId = :key and t.itemOrderedSKU = :key2");
	    	        query.setString("key", orderID );
	    	        query.setString("key2", productSKU );
	    	    return (query.uniqueResult() != null);
	}
}