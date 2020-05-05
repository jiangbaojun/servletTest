package com.test.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/s1"},
        loadOnStartup = 1, name = "Servlet-s1", displayName = "s1",
        initParams = {
            @WebInitParam(name = "username", value = "tom"),
            @WebInitParam(name = "password", value = "123")}
)
public class Servlet1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("servlet-s1");
        ServletConfig servletConfig = this.getServletConfig();
        //获得init-param
        System.out.println("init-param（username）："+servletConfig.getInitParameter("username"));
        System.out.println("init-param（password）："+servletConfig.getInitParameter("password"));
        //session
        request.getSession().setAttribute("name","123");
        request.getRequestDispatcher("/html/index.html").forward(request, response);
    }
}