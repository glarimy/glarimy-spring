package com.glarimy.bank.service;

import java.util.HashMap;
import java.util.Map;

import com.glarimy.bank.api.AccountNotFoundExcetion;
import com.glarimy.bank.api.Bank;
import com.glarimy.bank.api.BankException;
import com.glarimy.bank.api.Customer;
import com.glarimy.bank.api.InvalidRequestException;

public class BankImpl implements Bank {
	private Map<Integer, Account> accounts;
	private static int NUMBER = 22071972;

	public BankImpl() {
		accounts = new HashMap<>();
	}

	@Override
	public int openAccountFor(Customer customer) throws InvalidRequestException, BankException {
		if (customer == null || customer.getName() == null || customer.getName().trim().length() == 0
				|| customer.getPhoneNumber() < 1)
			throw new InvalidRequestException();
		Account account = new Account();
		account.setNumber(NUMBER++);
		account.setCustomer(customer);
		accounts.put(account.getNumber(), account);
		return account.getNumber();
	}

	@Override
	public double getBalance(int number) throws AccountNotFoundExcetion, BankException {
		Account account = accounts.get(number);
		if (account == null)
			throw new AccountNotFoundExcetion();
		return account.getBalance();
	}

}
