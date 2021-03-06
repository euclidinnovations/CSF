package com.euclid.persistence.Orders.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.euclid.persistence.Orders.model.OrderTotal;

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
    
    @Override
    public void deleteAll() {
    	sessionFactory.getCurrentSession().createQuery("delete from orders").executeUpdate();
    }


	@Override
	public Boolean exists(String id) {
		Query query = sessionFactory.getCurrentSession().             
	    	    createQuery("select 1 from OrderTotal t where t.orderId = :key");
	    	        query.setString("key", id );
	    	    return (query.uniqueResult() != null);
	}


	@Override
	public Boolean remove(String orderID) {
				try {
			            OrderTotal ordTotal = (OrderTotal) sessionFactory.getCurrentSession().get(OrderTotal.class, orderID);
			            deleteOrderTotal(ordTotal);
			       }
			
			        catch (HibernateException e) {
			            e.printStackTrace();
			          //  sessionFactory.getCurrentSession().getTransaction().rollback();
			
			        }
	    	    return true;
		
	}
}