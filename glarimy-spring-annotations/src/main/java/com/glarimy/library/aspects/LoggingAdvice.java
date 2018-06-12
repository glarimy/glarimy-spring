package com.glarimy.library.aspects;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.ThrowsAdvice;
import java.lang.reflect.Method;

public class LoggingAdvice implements MethodBeforeAdvice, AfterReturningAdvice,
		ThrowsAdvice {

	public LoggingAdvice() {

	}

	public void before(Method method, Object[] args, Object target)
			throws Throwable {
		System.out.println(">>>>>>>> Entering " + target.getClass().getName()
				+ "." + method.getName());
		System.out.println(">>>>>>>> Arguments: " + args);
	}

	public void afterReturning(Object returnValue, Method method,
			Object[] args, Object target) throws Throwable {
		System.out.println(">>>>>>>> Leaving: " + target.getClass().getName()
				+ "." + method.getName());
		System.out.println(">>>>>>>> Arguments: " + args);
		System.out.println(">>>>>>>> Returning: " + returnValue);
	}

	public void afterThrowing(Throwable throwable) {
		System.out.println(">>>>>>>> Thrown " + throwable.getMessage());
	}
}