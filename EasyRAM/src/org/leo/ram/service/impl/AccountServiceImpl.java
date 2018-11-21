package org.leo.ram.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.leo.ram.dao.AccountDao;
import org.leo.ram.domain.Account;
import org.leo.ram.domain.PageBean;
import org.leo.ram.service.AccountService;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class AccountServiceImpl implements AccountService{
	
	private AccountDao accountDao;

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@Override
	public void save(Account account) {
		accountDao.save(account);
	}

	@Override
	public PageBean<Account> findByPage(DetachedCriteria detachedCriteria, Integer currentPage, Integer pageSize) {
		PageBean<Account> pageBean = new PageBean<Account>();
		//封装当前页数
		pageBean.setCurrentPage(currentPage);
		//封装每页显示数
		pageBean.setPageSize(pageSize);
		//封装总记录数
		//1. 调用Dao
		Integer totalCount = accountDao.findCount(detachedCriteria);
		//2. 封装总记录数
		pageBean.setTotalCount(totalCount);
		//封装总页数
		double tc = totalCount.doubleValue();
		int num = (int) Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num);
		//封装每页显示数据的集合
		Integer begin = (currentPage - 1 ) * pageSize;
		List<Account> list = accountDao.findByPage(detachedCriteria, begin, pageSize);
		pageBean.setList(list);
		return pageBean;
	}
	

}
