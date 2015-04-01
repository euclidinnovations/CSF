package com.euclid.persistence.Orders.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.euclid.persistence.Orders.dao.CSFSaveDAO;
import com.euclid.persistence.Orders.model.CSFSave;

@Service("csfSaveService")
public class CSFSaveServiceImpl implements CSFSaveService{

	@Autowired
	CSFSaveDAO csfSaveDAO;
	
	@Override
	@Transactional
	public void persistCSFSave(CSFSave csfSave) {
		csfSaveDAO.persistCSFSave(csfSave);
		
	}

	@Override
	@Transactional
	public void updateCSFSave(CSFSave csfSave) {
		csfSaveDAO.updateCSFSave(csfSave);
		
	}
	@Override
	@Transactional
	public CSFSave findCSFSaveById(String id) {
		return csfSaveDAO.findCSFSaveById(id);
	}

	@Override
	@Transactional
	public void deleteCSFSave(CSFSave csfSave) {
		csfSaveDAO.deleteCSFSave(csfSave);
		
	}

	@Override
	@Transactional
	public void deleteAll(String orderId) {
		csfSaveDAO.deleteAll(orderId);
		
	}

	@Override
	@Transactional
	public Boolean exists(String id) {
		return csfSaveDAO.exists(id);
	}

}