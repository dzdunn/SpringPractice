package com.tutorialspoint.springevents;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class CustomEventHandler implements ApplicationListener {
	
	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println(event.toString());
	}

}
