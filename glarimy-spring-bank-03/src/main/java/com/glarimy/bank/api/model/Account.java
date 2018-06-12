package com.glarimy.bank.api.model;

import java.util.List;

public class Account {
	private int number;
	private Customer customer;
	private double balance;
	private boolean active;
	private List<Transaction> transactions;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		System.out.println("Transactions: " + transactions);
		this.transactions = transactions;
	}

	@Override
	public String toString() {
		return "Account [number=" + number + ", customer=" + customer + ", balance=" + balance + ", active=" + active
				+ ", transactions=" + transactions + "]";
	}

}
