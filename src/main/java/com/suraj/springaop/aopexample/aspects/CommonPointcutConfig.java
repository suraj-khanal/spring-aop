package com.suraj.springaop.aopexample.aspects;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonPointcutConfig {
	
	@Pointcut("execution(* com.suraj.springaop.aopexample.*.*.*(..))")
	public void businessAndDataPackageConfig() {}
	
	@Pointcut("execution(* com.suraj.springaop.aopexample.business.*.*(..))")
	public void businessPackageConfig() {}
	
	@Pointcut("execution(* com.suraj.springaop.aopexample.data.*.*(..))")
	public void dataPackageConfig() {}
	
	@Pointcut("bean(*Service*)")
	public void allPackageConfigUsingBean() {}
	
	@Pointcut("@annotation(com.suraj.springaop.aopexample.annotations.TrackTime)")
	public void trackTimeAnnotation() {}
	
}
