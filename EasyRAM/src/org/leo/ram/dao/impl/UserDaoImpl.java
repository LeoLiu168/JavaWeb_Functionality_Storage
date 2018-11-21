package org.leo.ram.dao.impl;

import java.util.List;

import org.leo.ram.dao.UserDao;
import org.leo.ram.domain.User;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	@Override
	public void save(User user) {
		this.getHibernateTemplate().save(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public User login(User user) {
		List<User> list = (List<User>) this.getHibernateTemplate().
		find("from User where user_code=? and user_password=?", user.getUser_code(), user.getUser_password());
		if(list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

}
