package com.glarimy.library.aspects;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;


public class LoggingInterceptor implements MethodInterceptor{
	public LoggingInterceptor() {

	}

	public Object invoke(MethodInvocation invocation) throws Throwable{
		try	{
			System.out.println("<<<<<<<< Entering " + invocation.getMethod().getName());
			Object returnValue = invocation.proceed();
			System.out.println("<<<<<<<< Leaving " + invocation.getMethod().getName());
			System.out.println("<<<<<<<< Returing:  " + returnValue);
			return returnValue;
		} catch (Exception e) {
			System.out.println(e);
			throw e;
		}
	}
}