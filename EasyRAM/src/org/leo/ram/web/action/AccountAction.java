package org.leo.ram.web.action;

import org.leo.ram.domain.Account;
import org.leo.ram.service.AccountService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AccountAction extends ActionSupport implements ModelDriven<Account>{

	private static final long serialVersionUID = 112735125351L;
	
	//模型驱动使用的对象
	private Account account = new Account();
	
	@Override
	public Account getModel() {
		return account;
	}
	
	//注入Service
	private AccountService accountService;

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}
	
	/**
	 * 账户管理:跳转到添加页面的方法 saveUI
	 */
	public String saveUI() {
		return "saveUI";
	}
}
