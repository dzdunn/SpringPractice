package com.tutorialspoint.springevents;

import org.springframework.context.ApplicationEvent;

public class CustomEvent extends ApplicationEvent{

	public CustomEvent(Object source) {
		super(source);
	}
	
	public CustomEvent(CustomEventPublisher source) {
		super(source);
	}

	public String toString() {
		return "My Custom Event";
	}

}
