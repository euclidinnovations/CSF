package com.euclid.persistence.Orders.dao;



import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.euclid.persistence.Orders.model.CSFSave;


@Repository("csfSaveDAO")


public class CSFSaveDAOImpl implements CSFSaveDAO {
 @Autowired
    private SessionFactory sessionFactory;

    @Override

    public void persistCSFSave(CSFSave csfSave) {
        sessionFactory.getCurrentSession().persist(csfSave);
    }
 

    @Override
    public CSFSave findCSFSaveById(String id) {
        return (CSFSave) sessionFactory.getCurrentSession().get(CSFSave.class, id);
    }
 

    @Override
    public void updateCSFSave(CSFSave csfSave) {
        sessionFactory.getCurrentSession().update(csfSave);
    }

    @Override
    public void deleteCSFSave(CSFSave csfSave) {

        sessionFactory.getCurrentSession().delete(csfSave);

    }
    
    @Override
    public void deleteAll() {
    	sessionFactory.getCurrentSession().createQuery("truncate from CSFSave").executeUpdate();
    }
    
    @Override    
    public Boolean exists (String id) {
    	    Query query = sessionFactory.getCurrentSession().             
    	    createQuery("select 1 from CSFSave t where t.orderId = :key");
    	        query.setString("key", id );
    	        System.out.println("ORDER ID WHILE CHECKING"+id);
    	    return (query.uniqueResult() != null);
    	}    	
    
}