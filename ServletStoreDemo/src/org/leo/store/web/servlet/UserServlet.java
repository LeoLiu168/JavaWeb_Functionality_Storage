package org.leo.store.web.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.leo.store.domain.User;
import org.leo.store.service.UserService;
import org.leo.store.service.impl.UserServiceImp;
import org.leo.store.utils.MailUtils;
import org.leo.store.utils.MyBeanUtils;
import org.leo.store.utils.UUIDUtils;
import org.leo.store.web.base.BaseServlet;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends BaseServlet {
	
	private static final long serialVersionUID = 1821836551283L;
	
	//处理从首页跳到注册页面的逻辑
	public String registUI(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return "/jsp/register.jsp";
	}
	//处理从首页跳到登录页面的逻辑
	public String loginUI(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return "/jsp/login.jsp";
	}
	
	//用户注册模块的注册功能点
	public String userRegist(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 接收表单参数
		Map<String, String[]> map = request.getParameterMap();
		//新建User对象
		User user = new User();
		//调用Utils的popultae方法为User对象赋值
		//MyBeanUtil封装了Apache Common的BeanUtil方法, 添加了转换时间格式的代码
		MyBeanUtils.populate(user, map);
		// 为用户的其他属性赋值,如用户编号, 状态码, 激活码
		user.setUid(UUIDUtils.getId());
		user.setState(0);
		user.setCode(UUIDUtils.getCode());
		System.out.println(user);

		/*
		 * //遍历map中的数据 Set<String> keySet = map.keySet(); Iterator<String>
		 * iterator = keySet.iterator(); while(iterator.hasNext()){ String
		 * str=iterator.next(); System.out.println(str); String[] strs =
		 * map.get(str); for (String string : strs) {
		 * System.out.println(string); } System.out.println(); }
		 */

		// 注册功能点封装在业务层中
		UserService UserService = new UserServiceImp();
		try {
			UserService.userRegist(user);
			// 注册成功,向用户邮箱发送信息,跳转到提示页面
			// 调用MailUtils方法, 发送激活邮件
			MailUtils.sendMail(user.getEmail(), user.getCode());
			request.setAttribute("msg", "用户注册成功,请激活!");

		} catch (Exception e) {
			// 通过使用异常的方式, 来处理注册失败的业务逻辑, 跳转到提示页面
			request.setAttribute("msg", "用户注册失败,请重新注册!");

		}
		return "/jsp/info.jsp";
	}
	//用户激活功能点
	public String active(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//获取激活码
		String code=request.getParameter("code");
		//调用业务层激活功能
		UserService UserService=new UserServiceImp();
		boolean flag=UserService.userActive(code);
		
		//进行激活信息提示
		if(flag==true){
			//用户激活成功,向request放入提示信息,转发到登录页面
			request.setAttribute("msg", "用户激活成功,请登录!");
			return "/jsp/login.jsp";
		}else{
			//用户激活失败,向request放入提示信息,转发到提示页面
			request.setAttribute("msg", "用户激活失败,请重新激活!");
			return  "/jsp/info.jsp";
		}
	}
	
	//userLogin
	public String userLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//获取用户数据(账户/密码)
		User user=new User();
		MyBeanUtils.populate(user, request.getParameterMap());
		
		//调用业务层登录功能
		UserService UserService=new UserServiceImp();
		User user02=null;
		try {
			//select * from user where username=?  and password=?
			user02=UserService.userLogin(user);
			//用户登录成功,将用户信息放入session中
			request.getSession().setAttribute("loginUser", user02);
			//重定向到首页
			response.sendRedirect("/store_v5/index.jsp");
			return null;
		} catch (Exception e) {
			//用户登录失败
			String msg=e.getMessage();
			System.out.println(msg);
			//向request放入失败的信息
			request.setAttribute("msg", msg);
			return "/jsp/login.jsp";
		}
	}
	
	//用户退出
	public String logOut(HttpServletRequest request, HttpServletResponse response) throws Exception {
		  //清除session
		  request.getSession().invalidate();
		  //重新定向到首页
		  response.sendRedirect("/store_v5/index.jsp");
		  return null;	
	}
	

}
