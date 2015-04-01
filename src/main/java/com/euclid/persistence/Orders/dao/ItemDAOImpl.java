package com.euclid.persistence.Orders.dao;

import java.util.List;

import org.hibernate.Query;
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
    
    @Override
	public Boolean exists(String id) {
		Query query = sessionFactory.getCurrentSession().             
	    	    createQuery("select 1 from Item t where t.SKU = :key");
	    	        query.setString("key", id );
	    	    return (query.uniqueResult() != null);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<String> getMappedItems(String itemString) {
		
		// // System.out.println("Item String : "+itemString);
		Query query = sessionFactory.getCurrentSession().             
	    	    createQuery("select t.itemName from Item t where t.itemName LIKE :key");
	    	        query.setParameter("key", "%"+itemString+"%");
	    	        
	    	        List<String> mappedItems = query.list();
	    	     
		return mappedItems;
	}
}