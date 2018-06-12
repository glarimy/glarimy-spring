package com.glarimy.bank.api.model;

import java.util.Date;

public class Transaction {
	private Date date;
	private String type;
	private double amount;
	private double balance;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Transaction [date=" + date + ", type=" + type + ", amount=" + amount + ", balance=" + balance + "]";
	}

}
