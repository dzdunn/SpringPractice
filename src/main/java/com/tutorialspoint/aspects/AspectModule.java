package com.tutorialspoint.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

//@Aspect
public class AspectModule {

	@Pointcut("execution(* com.tutorialspoint.*.*(..))")
	private void businessService() {
	};

	@Before("execution(* com.tutorialspoint.*.*(..))")
	public void doBeforeTask() {
		System.out.println("Going to set up student profile");
	}

	@After("businessService()")
	public void afterTask() {
		System.out.println("Student profile has been set up.");
	}

	@AfterReturning(pointcut = "businessService()", returning = "retVal")
	public void afterReturningTask(Object retVal) {
		if (retVal != null) {
			System.out.println("Returning: " + retVal.toString());
		}

	}

	@AfterThrowing(pointcut = "businessService()", throwing = "ex")
	public void doAfterThrowingTask(IllegalArgumentException ex) {
		System.out.println("There has been an exception thrown: " + ex.toString());
	}

	@Around("businessService()")
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("TESTTTTTTTTTT");
		return pjp.proceed();
	}

}
