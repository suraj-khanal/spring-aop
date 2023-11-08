package com.suraj.springaop.aopexample.aspects;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonPointcutConfig {
	
	@Pointcut("execution(* com.suraj.springaop.aopexample.*.*.*(..))")
	public void businessAndDataPackageConfig() {}
}
