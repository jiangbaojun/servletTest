package com.test.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * session监听器
 * @Author: jiangbaojun
 */
@WebListener("session监听")
public class WebSessionListener implements HttpSessionListener {
    
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("session init");
        System.out.println(se.getSession().getId());
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("session destory");
    }
}
