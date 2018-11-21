package org.leo.ram.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.leo.ram.dao.AccountDao;
import org.leo.ram.domain.Account;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

/**
 * 账户Dao接口的实现类
 * @author leoliu
 *
 */
public class AccountDaoImpl extends HibernateDaoSupport implements AccountDao {

	@Override
	public void save(Account account) {
		this.getHibernateTemplate().save(account);
	}
	/**
	 * 条件统计个数的方法
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Integer findCount(DetachedCriteria detachedCriteria) {
		detachedCriteria.setProjection(Projections.rowCount());
		List<Long> list = (List<Long>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
		if(list.size() > 0) {
			return list.get(0).intValue();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Account> findByPage(DetachedCriteria detachedCriteria, Integer begin, Integer pageSize) {
		detachedCriteria.setProjection(null);
		return (List<Account>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
	}

}
