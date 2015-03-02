package com.euclid.persistence.Orders.service;

import com.euclid.persistence.Orders.model.CSFSave;

public interface CSFSaveService {

	void persistCSFSave(CSFSave csfSave);

	CSFSave findCSFSaveById(String id);

	void updateCSFSave(CSFSave csfSave);

	void deleteCSFSave(CSFSave csfSave);
	
	void deleteAll();
	
	Boolean exists(String id);
}