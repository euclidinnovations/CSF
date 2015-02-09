package com.euclid.persistence.Orders.service;

import com.euclid.persistence.Orders.model.CSF;

public interface CSFService {

	void persistCSF(CSF csf);

	CSF findCSFById(String id);

	void updateCSF(CSF csf);

	void deleteCSF(CSF csf);
}