package org.leo.ram.dao;

import org.leo.ram.domain.User;

public interface UserDao {

	void save(User user);

	User login(User user);

}
