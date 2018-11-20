package org.leo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 减少Servlet的第一种范式:
 * 1. 通过抽取request中的参数值比如method, 匹配方法名
 * 2. 调用方法
 * 3. 请求转发至对应的路径
 */
public class ServletDemo01 extends HttpServlet {
	private static final long serialVersionUID = 169241267571242L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取客户端提交到服务端的method对应的值
				String md=request.getParameter("method");
				//定义变量,存放功能执行完毕之后要转发的路径
				String path=null;
				
				//通过判断md中不同的内容来决定本次功能
				if("addStu".equals(md)){
					path=addStu(request, response);
				}else if("delStu".equals(md)){
					path=delStu(request, response);
				}else if("checkStu".equals(md)){
					path=checkStu(request, response);
				}else if("".equals(md)){
					
				}
				if(null!=path){
					//服务端的请求转发
					request.getRequestDispatcher(path).forward(request, response);
				}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected String addStu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("添加学生");
		return "/test.html";
		
	}
	protected String delStu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("删除学生");
		return "/test.html";
		
	}
	protected String checkStu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("检查学生");
		response.getWriter().println("DDDDDD");
		return null;
	}

}
