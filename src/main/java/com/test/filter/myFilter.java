package com.test.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 过滤器
 * @Author: jiangbaojun
 */
@WebFilter(filterName = "myFilter",
        servletNames = "servlet-s3", urlPatterns = "/s21",
        initParams = {@WebInitParam(name = "filterInit", value = "jerry")})
public class myFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
        String username = filterConfig.getInitParameter("filterInit");
        System.out.println(username);
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("myFilter exec");
        if(((HttpServletRequest) request).getRequestURI().contains("s21")){
            response.getWriter().write("error s21");
            return;
        }
        chain.doFilter(request, response);
    }

    public void destroy() {
        System.out.println("myFilter destory");
    }
}
