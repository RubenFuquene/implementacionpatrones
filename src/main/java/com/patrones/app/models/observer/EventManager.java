package com.patrones.app.models.observer;

import com.patrones.app.models.mediator.Mediator;
import com.patrones.app.models.mediator.OrderMediator;

public class EventManager {
	
	private Mediator mediator;
	
	public EventManager() {
		super();
		this.mediator = new OrderMediator();
	}

	
	public void addObserver(ObserverOrders observer) {
        ((OrderMediator) this.mediator).addInterested(observer);
    }

	
	public void removeObserver(ObserverOrders observer) {
		((OrderMediator) this.mediator).removeInterested(observer);
    }
	
	public void notifyObservers(String status) {
		if (this.mediator != null) {
			this.mediator.notify(this, status);
		}
    }
}
