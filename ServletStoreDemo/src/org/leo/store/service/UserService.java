package org.leo.store.service;

import java.sql.SQLException;

import org.leo.store.domain.User;

public interface UserService {

	void userRegist(User user) throws SQLException;

	boolean userActive(String code) throws SQLException;

}
