package com.tutorialspoint.aspects;

import org.aspectj.lang.ProceedingJoinPoint;

public class Logging {
	
	public void beforeAdvice() {
		System.out.println("Going to setup student profile");
	}
	
	public void afterAdvice() {
		System.out.println("Student profile has been setup.");
	}
	
	public void afterReturningAdvice(Object retVal) {
		System.out.println("Returning:" + retVal.toString());
	}
	
	public void afterThrowingAdvice(IllegalArgumentException ex) {
		System.out.println("There has been an exception: " + ex.toString());
	}
	
	public Object allAround(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("ALL AROUND!");
		Object obj = pjp.proceed();
		return obj;
	}

}
