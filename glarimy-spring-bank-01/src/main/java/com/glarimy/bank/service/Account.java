package com.glarimy.bank.service;

import com.glarimy.bank.api.Customer;

public class Account {
	private int number;
	private Customer customer;
	private double balance;
	private boolean active;

	public Account() {

	}

	public Account(int number, Customer customer, double balance, boolean active) {
		super();
		this.number = number;
		this.customer = customer;
		this.balance = balance;
		this.active = active;
	}

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
}
