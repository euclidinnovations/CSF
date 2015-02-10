package com.euclid.persistence.Orders.service;

import com.euclid.persistence.Orders.model.OriginalOrder;

public interface OriginalOrderService {

	void persistOriginalOrder(OriginalOrder originalOrder);

	OriginalOrder findOriginalOrderById(String id);

	void updateOriginalOrder(OriginalOrder originalOrder);

	void deleteOriginalOrder(OriginalOrder originalOrder);

	boolean exists(String orderID, String sku);
}