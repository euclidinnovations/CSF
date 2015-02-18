package com.euclid.persistence.Orders.service;

import java.util.List;

import com.euclid.persistence.Orders.model.OriginalOrder;

public interface OriginalOrderService {

	void persistOriginalOrder(OriginalOrder originalOrder);

	OriginalOrder findOriginalOrderById(String id);

	void updateOriginalOrder(OriginalOrder originalOrder);

	void deleteOriginalOrder(OriginalOrder originalOrder);

	boolean exists(String orderID, String sku);

	List<String> getAllOriginalItemSKUs(String orderID);
}