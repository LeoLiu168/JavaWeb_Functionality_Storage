package org.leo.ram.service.impl;

import org.leo.ram.dao.UserDao;
import org.leo.ram.domain.User;
import org.leo.ram.service.UserService;
import org.leo.ram.utils.MD5Utils;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户管理Service接口实现类
 * @author leoliu
 *
 */
@Transactional
public class UserServiceImpl implements UserService {

	//注入Dao
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	//业务层用户注册方法
	public void regist(User user) {
		//对密码进行MD5加密
		user.setUser_password(MD5Utils.md5(user.getUser_password()));
		//设置默认的状态码1
		user.setUser_state("1");
		//调用Dao
		userDao.save(user);
	}

	@Override
	public User login(User user) {
		user.setUser_password(MD5Utils.md5(user.getUser_password()));
		return userDao.login(user);
	}

}
