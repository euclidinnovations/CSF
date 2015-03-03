package com.euclid.persistence.Orders.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
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
    
    @SuppressWarnings("unchecked")
	@Override
    public List<Object[]> getLookupItems(String orderId){
    			
		Query query = sessionFactory.getCurrentSession().
				createQuery("select c.itemOrderedName,c.itemRecievedName from ModifiedItem c WHERE c.orderId=:key");
				query.setString("key", orderId);
		List<Object[]> rows = query.list();
		return rows;
    }

    @Override
    public String getModId(String orderId,String key, String value){
    			
		Query query = sessionFactory.getCurrentSession().
				createQuery("select c.modId from ModifiedItem c WHERE c.orderId=:key and c.itemOrderedName=:stringKey");
				query.setString("key", orderId);
				query.setString("stringKey", key);

		//System.out.println("KEY "+key);
	//	System.out.println("orderId "+orderId);
		List<String> rows1 = query.list();
	//	System.out.println("String rows 1 from get MODIF:"+rows1);
	//	System.out.println("String rows 1 from get MODIF:"+rows1.get(0));
		if(rows1.size()!=0){
			return rows1.get(0);
			}
		return null;
    }

	
	@Override
	public boolean exists(String modID) {
		Query query = sessionFactory.getCurrentSession().             
	    	    createQuery("select 1 from ModifiedItem t where t.modId = :key");
	    	        query.setString("key", modID );
	    	    return (query.uniqueResult() != null);
	}


	@Override
	public void updateMItem(String orderId, String key, String value) {
		try {
	//		System.out.println("updateMItem:::");
			String modId= orderId + key;
			String val = getModId(orderId,key,value);
			if(val!=null){
		//		System.out.println("updateMItem:::"+modId);
	            ModifiedItem modItem = (ModifiedItem) sessionFactory.getCurrentSession().get(ModifiedItem.class, val);
	            deleteModifiedItem(modItem);
	    //        System.out.println("updateMItem::deleted:"+modId);
	            modItem.setModId(modId);
	            modItem.setOrderId(orderId);
	            modItem.setItemOrderedName(key);
	            modItem.setItemRecievedName(value);
	            persistModifiedItem(modItem);
			}
       }

        catch (HibernateException e) {
            e.printStackTrace();
          //  sessionFactory.getCurrentSession().getTransaction().rollback();

        }
		
	}
}