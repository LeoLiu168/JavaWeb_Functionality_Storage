package org.leo.ram.service;

import org.leo.ram.domain.User;

public interface UserService {

	void regist(User user);

	User login(User user);

}
