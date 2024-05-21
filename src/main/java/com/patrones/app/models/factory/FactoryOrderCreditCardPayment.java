package com.patrones.app.models.factory;

import com.patrones.app.models.Order;
import com.patrones.app.models.OrderWithCreditCardPayment;

public class FactoryOrderCreditCardPayment extends FactoryOrder {

	@Override
	public Order createOrder() {
		return new OrderWithCreditCardPayment();
	}

}
