package com.glarimy.bank.data;

import java.util.Map;

import com.glarimy.bank.api.model.Account;

public class AccountInMemoryDAO implements AccountDAO {
	private Map<Integer, Account> ledger;
	private static int NUMBER = 22071972;

	public AccountInMemoryDAO(Map<Integer, Account> ledger) {
		super();
		this.ledger = ledger;
	}

	@Override
	public int save(Account account) {
		account.setNumber(NUMBER++);
		ledger.put(account.getNumber(), account);
		return account.getNumber();
	}

	@Override
	public Account find(int number) {
		return ledger.get(number);
	}
}
