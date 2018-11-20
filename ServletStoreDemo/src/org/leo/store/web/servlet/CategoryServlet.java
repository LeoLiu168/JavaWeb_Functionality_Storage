package org.leo.store.web.servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.leo.store.domain.Category;
import org.leo.store.service.CategoryService;
import org.leo.store.service.impl.CategoryServiceImp;
import org.leo.store.utils.JedisUtils;
import org.leo.store.web.base.BaseServlet;

import net.sf.json.JSONArray;
import redis.clients.jedis.Jedis;

/**
 * Servlet implementation class CategoryServlet
 */
public class CategoryServlet extends BaseServlet {
	
	private static final long serialVersionUID = 18126312532423124L;

	//findAllCats
	public String findAllCats(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//在redis中获取全部分类信息
		Jedis jedis=JedisUtils.getJedis();
		String jsonStr=jedis.get("allCats");
		if(null==jsonStr||"".equals(jsonStr)){
			//调用业务层获取全部分类
			CategoryService CategoryService=new CategoryServiceImp();
			List<Category> list = CategoryService.getAllCats();
//			req.setAttribute("CatList", list);
//			return "/jsp/info.jsp";
			//将全部分类转换为JSON格式的数据
			jsonStr=JSONArray.fromObject(list).toString();
			System.out.println(jsonStr);
			//将获取到的JSON格式的数据存入redis
			jedis.set("allCats", jsonStr);
			System.out.println("redis缓存中没有数据");
			//将全部分类信息响应到客户端
			//告诉浏览器本次响应的数据是JSON格式的字符串
			resp.setContentType("application/json;charset=utf-8");
			resp.getWriter().print(jsonStr);			
		}else{
			System.out.println("redis缓存中有数据");
			
			//将全部分类信息响应到客户端
			//告诉浏览器本次响应的数据是JSON格式的字符串
			resp.setContentType("application/json;charset=utf-8");
			resp.getWriter().print(jsonStr);
		}
		
		JedisUtils.closeJedis(jedis);

		return null;
	}
}
