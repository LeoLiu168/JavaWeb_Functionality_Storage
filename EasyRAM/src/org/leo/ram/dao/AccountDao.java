package org.leo.ram.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.leo.ram.domain.Account;

/**
 * 账户操作的Dao
 * @author leoliu
 *
 */
public interface AccountDao {

	void save(Account account);

	Integer findCount(DetachedCriteria detachedCriteria);

	List<Account> findByPage(DetachedCriteria detachedCriteria, Integer begin, Integer pageSize);

}
