package com.glarimy.bank.data;

import com.glarimy.bank.api.model.Account;

public interface AccountDAO {
	public int save(Account account);

	public Account find(int number);
}
