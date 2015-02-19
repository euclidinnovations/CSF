package com.euclid.persistence.Orders.dao;

import java.util.List;

import org.hibernate.Query;
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
    
    @Override
    public void deleteAll() {
    	sessionFactory.getCurrentSession().createQuery("delete from orders").executeUpdate();
    }


	@Override
	public Boolean exists(String id) {
		Query query = sessionFactory.getCurrentSession().             
	    	    createQuery("select 1 from Order t where t.orderId = :key");
	    	        query.setString("key", id );
	    	    return (query.uniqueResult() != null);
	}


	@Override
	public List<String> getAllOrderIDS() {
		Query query = sessionFactory.getCurrentSession().             
	    	    createQuery("select o.orderId from Order o");
	    	         
	    	        List<String> orderIDList = query.list();
		return orderIDList;
	}
}