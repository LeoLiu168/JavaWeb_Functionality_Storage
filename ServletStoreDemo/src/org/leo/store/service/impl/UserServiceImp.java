package org.leo.store.service.impl;

import java.sql.SQLException;

import org.leo.store.dao.UserDao;
import org.leo.store.dao.impl.UserDaoImp;
import org.leo.store.domain.User;
import org.leo.store.service.UserService;

public class UserServiceImp implements UserService {

	@Override
	public void userRegist(User user) throws SQLException {
		
		//实现注册功能
		UserDao UserDao=new UserDaoImp();
		UserDao.userRegist(user);
	}
	
	@Override
	public boolean userActive(String code) throws SQLException {
		//实现激活功能
		UserDao UserDao=new UserDaoImp();
		///对DB发送select * from user where code=?
		User user=UserDao.userActive(code);
		
		if(null!=user){
			//可以根据激活码查询到一个用户
			//修改用户的状态,清除激活码
			user.setState(1);
			user.setCode(null);
			//对数据库执行一次真实的更新操作  update user set state=1 , code=null where uid=?
			//update user set username=? , password=? ,name =? ,email=?, telephone =? ,birthday =? ,sex=? ,state=? ,code= ? where uid=?
			UserDao.updateUser(user);
			return  true;
		}else{
			//不可以根据激活码查询到一个用户
			return false;
		}
	}

}
