package com.suraj.springaop.aopexample.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspectAfter {
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	/* 
	 * @After executes irrespective whether method is successful or throws exception
	 *  @AfterThrowing only executes if the method throws an exception
	 * */
	
	
	//Pointcut - When?
	// execution(* PACKAGE.*.*(..))
	@After("execution(* com.suraj.springaop.aopexample.*.*.*(..))")
	public void logMethodCallAfterExecution(JoinPoint joinPoint) {
		
		logger.info("After Aspect - {} has executed", joinPoint);
		
		//After Aspect - execution(int[] com.suraj.springaop.aopexample.data.DataService1.retrieveData()) has executed
		//After Aspect - execution(int com.suraj.springaop.aopexample.business.BusinessService1.calculateMax()) has executed

	}
	
	@AfterThrowing(
		pointcut = "execution(* com.suraj.springaop.aopexample.*.*.*(..))",
		throwing = "exception")
	public void logMethodCallAfterThrowingException(JoinPoint joinPoint, Exception exception) {
		
		logger.info("AfterThrowing Aspect - {} has thrown an exception {}", joinPoint, exception);
		
	}
	
	@AfterReturning(
		pointcut = "execution(* com.suraj.springaop.aopexample.*.*.*(..))",
		returning = "resultValue")
	public void logMethodCallAfterSuccessfulExecution(JoinPoint joinPoint, Object resultValue) {
		
		logger.info("AfterReturning Aspect - {} has returned {}", joinPoint, resultValue);
		
	}

}
