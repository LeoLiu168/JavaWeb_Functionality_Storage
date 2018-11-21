package org.leo.ram.service;

import org.hibernate.criterion.DetachedCriteria;
import org.leo.ram.domain.Account;
import org.leo.ram.domain.PageBean;

public interface AccountService {

	void save(Account account);

	PageBean<Account> findByPage(DetachedCriteria detachedCriteria, Integer currentPage, Integer pageSize);

}
