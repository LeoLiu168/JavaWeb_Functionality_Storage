package org.leo.store.web.servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.leo.store.domain.Product;
import org.leo.store.service.ProductService;
import org.leo.store.service.impl.ProductServiceImp;
import org.leo.store.web.base.BaseServlet;

/**
 * Servlet implementation class IndexServlet
 */
public class IndexServlet extends BaseServlet {
	
	private static final long serialVersionUID = 16216375238123L;

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//调用业务层功能:获取全部分类信息,返回集合
		//CategoryService CategoryService=new CategoryServiceImp();
		//List<Category> list=CategoryService.getAllCats();
		//将返回的集合放入request
		//request.setAttribute("allCats", list);
		
		//调用业务层查询最新商品,查询最热商品,返回2个集合
		ProductService ProductService=new ProductServiceImp();
		List<Product> list01=ProductService.findHots();
		List<Product> list02=ProductService.findNews();
		//将2个集合放入到request
		request.setAttribute("hots", list01);
		request.setAttribute("news", list02);
		//转发到真实的首页
		return "/jsp/index.jsp";
	}
    

}
