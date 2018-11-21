package org.leo.ram.web.action;

import org.hibernate.criterion.DetachedCriteria;
import org.leo.ram.domain.Account;
import org.leo.ram.domain.PageBean;
import org.leo.ram.service.AccountService;

import com.opensymphony.xwork2.ActionContext;
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
	
	//使用setter方法注入当前页
	private Integer currentPage = 1;
	
	public void setCurrentPage(Integer currentPage) {
		if(currentPage == null) {
			currentPage = 1;
		}
		this.currentPage = currentPage;
	}
	
	//使用setter方法注入每页显示数
	private Integer pageSize = 3;

	public void setPageSize(Integer pageSize) {
		if(pageSize == null) {
			pageSize = 3;
		}
		this.pageSize = pageSize;
	}

	/**
	 * 账户管理:跳转到添加页面的方法 saveUI
	 */
	public String saveUI() {
		return "saveUI";
	}
	
	/**
	 * 新增账户的方法
	 * @return none
	 */
	public String save() {
		accountService.save(account);
		return NONE;
	}
	
	/**
	 * 查询账户的方法
	 * @return
	 */
	public String findAll() {
		//使用DetachedCriteria对象(带分页的条件查询)接收分页参数
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Account.class);
		//调用业务查询
		PageBean<Account> pageBean = accountService.findByPage(detachedCriteria, currentPage, pageSize);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
}
