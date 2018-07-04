package com.glarimy.spring.biz;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Auditor {
	@Around("execution(* com.glarimy.spring.biz.GlarimyLibrary.*(..))")
	public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
		try {
			System.out.println(new Date() + " : Calling "
					+ joinPoint.getSignature().getName());
			Object val = joinPoint.proceed();
			System.out.println("Returning with " + val);
			return val;
		} catch (Exception e) {
			System.out.println(new Date() + " : Landed in "
					+ e.getClass().getName());
			throw e;
		}
	}
}