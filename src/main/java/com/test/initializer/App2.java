package com.test.initializer;

import javax.servlet.ServletContext;

/**
 * 测试类2
 * @Author: jiangbaojun
 * @Date: 2020/4/13 16:53
 */
public class App2 implements App{

    @Override
    public void onStartup(ServletContext servletContext) {
        System.out.println("我是app2");
    }
}
