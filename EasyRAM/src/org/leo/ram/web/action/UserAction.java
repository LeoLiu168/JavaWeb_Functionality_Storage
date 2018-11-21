package org.leo.ram.web.action;

import org.leo.ram.domain.User;
import org.leo.ram.service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * UserAcction
 * @author leoliu
 *
 */
public class UserAction extends ActionSupport implements ModelDriven<User> {

	/**
	 * add default serialVersionID
	 */
	private static final long serialVersionUID = 189123612361L;
	
	//模型驱动对象导入
	private User user = new User();

	@Override
	public User getModel() {		
		return user;
	}
	
	//使用set方法注入Service
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	/**
	 * 管理员注册方法
	 */
	public String regist() {
		userService.regist(user);
		return LOGIN;
	}
	
	/**
	 * 管理员登入方法
	 */
	public String login() {
		User existUser = userService.login(user);
		if (existUser == null) {
			this.addActionError("用户名或密码错误, 请重试!");
			return LOGIN;
		} else {
			//ServletActionContext.getRequest().getSession().setAttribute("existUser", existUser);
			ActionContext.getContext().getSession().put("existUser", existUser);
			return SUCCESS;
		}
	}
}
