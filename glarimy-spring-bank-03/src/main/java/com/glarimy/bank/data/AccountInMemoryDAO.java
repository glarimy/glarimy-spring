package com.glarimy.bank.data;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.glarimy.bank.api.model.Account;

@Repository
public class AccountInMemoryDAO implements AccountDAO {
	@Resource(name = "accounts")
	private Map<Integer, Account> ledger;
	private static int NUMBER = 22071972;

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
