package com.patrones.app.models.mediator;

import java.util.ArrayList;
import java.util.List;

import com.patrones.app.models.observer.ObserverOrders;

public class OrderMediator implements Mediator {
	
	private List<ObserverOrders> interested = new ArrayList<>();
	
	public void addInterested(ObserverOrders oneInterested) {
        interested.add(oneInterested);
    }
	
	public void removeInterested(ObserverOrders oneInterested) {
        interested.remove(oneInterested);
    }

	@Override
	public void notify(Object sender, String event) {
		for (ObserverOrders customer : interested) {
            customer.update(event);
        }
	}

}
