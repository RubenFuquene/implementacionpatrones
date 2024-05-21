package com.patrones.app.models.mediator;

public interface Mediator {
	void notify(Object sender, String event);
}
