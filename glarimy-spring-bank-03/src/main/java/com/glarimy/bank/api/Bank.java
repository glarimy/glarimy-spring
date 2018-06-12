package com.glarimy.bank.api;

import com.glarimy.bank.api.exceptions.AccountNotFoundExcetion;
import com.glarimy.bank.api.exceptions.BankException;
import com.glarimy.bank.api.exceptions.InvalidRequestException;
import com.glarimy.bank.api.model.Account;
import com.glarimy.bank.api.model.Customer;

public interface Bank {
	public int openAccountFor(Customer customer) throws InvalidRequestException, BankException;

	public double getBalance(int number) throws AccountNotFoundExcetion, BankException;
	
	public Account getAccountDetails(int number) throws AccountNotFoundExcetion, BankException;
}
