package com.test.listener;

import com.test.servlet.DynamicServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebListener;

/**
 * context监听器
 * @Author: jiangbaojun
 */
@WebListener("context监听")
public class WebContextListener implements ServletContextListener {
    
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        System.out.println("context init");
        //动态添加一个servlet,
        ServletRegistration.Dynamic servletRegistration = context.addServlet("servlet-dynamic", DynamicServlet.class);
        servletRegistration.addMapping("*.do");
        servletRegistration.setInitParameter("dName", "xiaoqiang");
    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("context destory");
    }
}
