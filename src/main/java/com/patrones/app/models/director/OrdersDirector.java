package com.patrones.app.models.director;

import com.patrones.app.models.builders.BuilderOrders;

public class OrdersDirector {
	public void createOrderMotherDays(BuilderOrders builder) {
		builder.setDiscount(0.3);
	}
}
