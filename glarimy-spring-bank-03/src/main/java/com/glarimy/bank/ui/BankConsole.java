package com.glarimy.bank.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.glarimy.bank.api.Bank;
import com.glarimy.bank.api.model.Account;
import com.glarimy.bank.api.model.Customer;

public class BankConsole {
	public static void main(String[] args) {
		ApplicationContext context 
		= new AnnotationConfigApplicationContext(BankConfiguration.class);
		Customer customer = context.getBean(Customer.class);
		Bank bank = context.getBean(Bank.class);
		int number = bank.openAccountFor(customer);
		Account account = bank.getAccountDetails(number);
		System.out.println(account);
	}
}
