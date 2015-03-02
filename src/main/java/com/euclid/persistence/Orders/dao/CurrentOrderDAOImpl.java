package com.euclid.persistence.Orders.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.euclid.persistence.Orders.model.CurrentOrder;

@Repository("currentOrderDAO")

public class CurrentOrderDAOImpl implements CurrentOrderDAO {
 @Autowired
    private SessionFactory sessionFactory;

    @Override

    public void persistCurrentOrder(CurrentOrder currentOrder) {
        sessionFactory.getCurrentSession().persist(currentOrder);
    }
 

    @Override
    public CurrentOrder findCurrentOrderById(String id) {
        return (CurrentOrder) sessionFactory.getCurrentSession().get(CurrentOrder.class, id);
    }
 

    @Override
    public void updateCurrentOrder(CurrentOrder currentOrder) {
        sessionFactory.getCurrentSession().update(currentOrder);
    }

    @Override
    public void deleteCurrentOrder(CurrentOrder currentOrder) {

        sessionFactory.getCurrentSession().delete(currentOrder);

    }
    
    @SuppressWarnings("unchecked")
	@Override
    public List<Object[]> getLookupItems(String orderId){
    			
		Query query = sessionFactory.getCurrentSession().
				createQuery("select c.itemRecievedSKU from CurrentOrder c");
		List<Object[]> rows = query.list();
		return rows;
    }


	@Override
	public boolean exists(String orderID, String productSKU) {
		Query query = sessionFactory.getCurrentSession().             
	    	    createQuery("select 1 from CurrentOrder t where t.orderId = :key and t.itemRecievedSKU = :key2");
	    	        query.setString("key", orderID );
	    	        query.setString("key2", productSKU );
	    	    return (query.uniqueResult() != null);
	}
}