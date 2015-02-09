package com.euclid.persistence.Orders.dao;

import com.euclid.persistence.Orders.model.CSF;

public interface CSFDAO {
	
		  void persistCSF(CSF csf);
		  
		  CSF findCSFById(String id);
		  
		  void updateCSF(CSF csf);
		  
		  void deleteCSF(CSF csf);
		  
}