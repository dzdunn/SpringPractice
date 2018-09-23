package com.tutorialspoint;

public class Student {
	
	private Long id;
	private Integer age;
	private String name;
	
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void printThrowException() {
		System.out.println("Exception raised");
		throw new IllegalArgumentException();
	}
	
}
