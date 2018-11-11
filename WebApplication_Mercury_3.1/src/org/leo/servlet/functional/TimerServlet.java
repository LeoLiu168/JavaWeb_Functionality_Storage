package org.leo.servlet.functional;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;


/**
 *  启动时实例化, 每隔一段时间在后台打印当前时间
 */
@SuppressWarnings("serial")
@WebServlet(loadOnStartup=1)
public class TimerServlet extends HttpServlet {
       
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		Timer t = new Timer(true);
		TimerTask task = new TimerTask() {

			@Override
			public void run() {
				System.out.println(new Date());
			}
		};
		t.schedule(task, 0, 1000);
	}

}
