package com.tutorialspoint;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloIndiaConfig {

	@Bean(name="helloIndia3BeanName")
	public HelloIndia helloIndia3Bean(){
		HelloIndia hi = new HelloIndia();
		hi.setMessage1("This must be working");
		return hi;
	}
}
