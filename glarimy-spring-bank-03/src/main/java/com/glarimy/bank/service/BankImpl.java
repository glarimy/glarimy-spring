package com.glarimy.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.glarimy.bank.api.Bank;
import com.glarimy.bank.api.exceptions.AccountNotFoundExcetion;
import com.glarimy.bank.api.exceptions.BankException;
import com.glarimy.bank.api.exceptions.InvalidRequestException;
import com.glarimy.bank.api.model.Account;
import com.glarimy.bank.api.model.Customer;
import com.glarimy.bank.data.AccountDAO;

@Service
public class BankImpl implements Bank {
	@Autowired
	private AccountDAO dao;

	@Override
	public int openAccountFor(Customer customer) throws InvalidRequestException, BankException {
		if (customer == null || customer.getName() == null || customer.getName().trim().length() == 0
				|| customer.getPhoneNumber() < 1)
			throw new InvalidRequestException();
		Account account = new Account();
		account.setCustomer(customer);
		dao.save(account);
		return account.getNumber();
	}

	@Override
	public double getBalance(int number) throws AccountNotFoundExcetion, BankException {
		Account account = dao.find(number);
		if (account == null)
			throw new AccountNotFoundExcetion();
		return account.getBalance();
	}

	@Override
	public Account getAccountDetails(int number) throws AccountNotFoundExcetion, BankException {
		Account account = dao.find(number);
		if (account == null)
			throw new AccountNotFoundExcetion();
		return account;
	}

}
