package com.euclid.persistence.Orders.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.euclid.persistence.Orders.dao.CSFDAO;
import com.euclid.persistence.Orders.model.CSF;

@Service("csfService")
public class CSFServiceImpl implements CSFService{

	@Autowired
	CSFDAO csfDAO;
	
	@Override
	@Transactional
	public void persistCSF(CSF csf) {
		csfDAO.persistCSF(csf);
		
	}

	@Override
	@Transactional
	public void updateCSF(CSF csf) {
		csfDAO.updateCSF(csf);
		
	}
	@Override
	@Transactional
	public CSF findCSFById(String id) {
		return csfDAO.findCSFById(id);
	}

	@Override
	@Transactional
	public void deleteCSF(CSF csf) {
		csfDAO.deleteCSF(csf);
		
	}

}