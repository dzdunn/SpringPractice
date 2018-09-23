package com.tutorialspoint.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.tutorialspoint.HelloIndia;
import com.tutorialspoint.HelloIndiaConfig;
import com.tutorialspoint.HelloWorld;

@Configuration
@Import(HelloIndiaConfig.class)
public class HelloWorldConfig {
	
	@Bean
	public HelloWorld helloWorld() {
		HelloWorld bean = new HelloWorld();
		bean.setMessage1("ANNOTATION AWESOME");
		return bean;
	}
	
	@Bean
	public HelloWorld helloWorldTwo() {
		HelloWorld bean = new HelloWorld();
		bean.setHelloIndia(helloIndia2Bean());
		return bean;
	}
	
	@Bean
	public HelloIndia helloIndia2Bean(){
		HelloIndia hi = new HelloIndia();
		hi.setMessage1("HELLO INDIA ANNOTED AUTOWIRED INJECT");
		return hi;
	}
	
	@Bean
	public HelloIndia helloIndia3ImportTest() {
		return new HelloIndiaConfig().helloIndia3Bean();
	}
}
