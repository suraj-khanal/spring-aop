package com.suraj.springaop.aopexample.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspectBefore {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	//Pointcut - When?
	// execution(* PACKAGE.*.*(..))
	@Before("execution(* com.suraj.springaop.aopexample.business.*.*(..))")
	public void logMethodCall1(JoinPoint joinPoint) {
		
		logger.info("Before Aspect -{} Method is Called with arguments: {}", joinPoint, joinPoint.getArgs());
		
		//Before Aspect - Method is Called - execution
		//(int com.suraj.springaop.aopexample.business.BusinessService1.calculateMax())
	}
	@Before("execution(* com.suraj.springaop.aopexample.data.*.*(..))")
	public void logMethodCall2(JoinPoint joinPoint) {
		
		logger.info("Before Aspect - Method is Called - {}", joinPoint);
		
		//Before Aspect - Method is Called - execution
		//(int[] com.suraj.springaop.aopexample.data.DataService1.retrieveData())
		
	}
	
	@Before("com.suraj.springaop.aopexample.aspects.CommonPointcutConfig.businessAndDataPackageConfig()") //WHEN
	public void logMethodCall3(JoinPoint joinPoint) {
		
		logger.info("Before Aspect - Method is Called - {}", joinPoint); //WHAT
		
		// Before Aspect - Method is Called - execution(int com.suraj.springaop.aopexample.business.BusinessService1.calculateMax())
		// Before Aspect - Method is Called - execution(int[] com.suraj.springaop.aopexample.data.DataService1.retrieveData())
		
		
	}

}
