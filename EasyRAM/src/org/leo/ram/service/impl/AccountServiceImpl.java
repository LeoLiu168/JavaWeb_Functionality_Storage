package org.leo.ram.service.impl;

import org.leo.ram.dao.AccountDao;
import org.leo.ram.service.AccountService;

public class AccountServiceImpl implements AccountService{
	
	private AccountDao accountDao;

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}
	

}
