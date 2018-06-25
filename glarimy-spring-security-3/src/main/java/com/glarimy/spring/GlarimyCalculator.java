package com.glarimy.spring;

import org.springframework.stereotype.Service;

@Service
public class GlarimyCalculator implements Calculator {
	@Override
	public int add(int a, int b) throws RuntimeException {
		return a + b;
	}
}