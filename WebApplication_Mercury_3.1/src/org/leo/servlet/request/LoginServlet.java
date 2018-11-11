package org.leo.servlet.request;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Login Servlet Demo
 */
@SuppressWarnings("serial")
@WebServlet(name="login", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String errMsg = "";
		//Servlet本身并不输出响应, 因此需要请求转发
		RequestDispatcher rd;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if("admin".equals(username)&&"123".equals(password)) {
			HttpSession session = request.getSession(true);
			session.setAttribute("name", username);
			rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}else {
			errMsg = "您的登录名或密码有误,请重新登录!";
			rd = request.getRequestDispatcher("/login.jsp");
			request.setAttribute("err", errMsg);
			rd.forward(request, response);
		}
	}

}
