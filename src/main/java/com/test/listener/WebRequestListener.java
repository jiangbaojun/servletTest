package com.test.listener;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * request监听器
 * @Author: jiangbaojun
 */
@WebListener("request监听")
public class WebRequestListener implements ServletRequestListener {
    
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("request destory");
    }

    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("request init");
    }
}
