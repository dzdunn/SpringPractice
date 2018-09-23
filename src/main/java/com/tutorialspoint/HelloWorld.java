package com.tutorialspoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class HelloWorld {
	
	private HelloIndia helloIndia;
	
	public HelloIndia getHelloIndia() {
		return helloIndia;
	}

	public void setHelloIndia(HelloIndia helloIndia) {
		this.helloIndia = helloIndia;
	}

	@Autowired
	@Qualifier("helloIndia2Bean")
	private HelloIndia helloIndia2;
	
	private String message1;
	
	private String message2;

	public String getMessage1() {
		return message1;
	}

	public void setMessage1(String message1) {
		this.message1 = message1;
	}

	public String getMessage2() {
		return message2;
	}

	public void setMessage2(String message2) {
		this.message2 = message2;
	}



}
