package com.glarimy.bank.api;

public interface Bank {
	public int openAccountFor(Customer customer) throws InvalidRequestException, BankException;

	public double getBalance(int number) throws AccountNotFoundExcetion, BankException;
}
