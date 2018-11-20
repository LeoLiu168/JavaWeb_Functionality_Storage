package org.leo.store.dao;

import java.sql.SQLException;

import org.leo.store.domain.User;

public interface UserDao {

	void userRegist(User user) throws SQLException;

	User userActive(String code) throws SQLException;

	void updateUser(User user) throws SQLException;

}
