package com.glarimy.bank.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.glarimy.bank.api.Customer;
import com.glarimy.bank.api.InvalidRequestException;
import com.glarimy.bank.api.AccountNotFoundExcetion;
import com.glarimy.bank.api.Bank;

public class BankConsole {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Bank bank = (Bank) context.getBean("bank");
		try {
			int number = bank.openAccountFor(new Customer("Krishna", 9731423166L));
			System.out.println("New account opned with number: " + number);
			System.out.println("The balance: " + bank.getBalance(number));
		} catch (InvalidRequestException ire) {
			System.out.println("Sorry. We are unable to create account since the data is invalid");
		} catch (AccountNotFoundExcetion anfe) {
			System.out.println("Sorry. Not able to retrieve the account with this number");
		} catch (Exception e) {
			System.out.println("Sorry. Internal error!");
		}
	}
}
