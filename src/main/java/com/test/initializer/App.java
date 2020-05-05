package com.test.initializer;

import javax.servlet.ServletContext;

/**
 * 定义接口
 * @Author: jiangbaojun
 * @Date: 2020/4/13 17:00
 */
public interface App {
    public void onStartup(ServletContext servletContext);
}
