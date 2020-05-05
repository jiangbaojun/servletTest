package com.test.async;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * 异步servlet测试
 */
@WebServlet(urlPatterns = "/async/demo", asyncSupported = true)
public class AsyncDemoServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
    throws IOException, ServletException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("进入Servlet的时间：" + new Date() + ".");
        out.flush();
 
        //在子线程中执行业务调用，并由其负责输出响应，主线程退出
        AsyncContext ctx = req.startAsync();
        ctx.addListener(new AsyncListenerDemo(), req, resp);
        ctx.start(new ExecutorTaskDemo(ctx));
        //也可以手动启用线程，或者采用线程池
//        new Thread(new ExecutorTaskDemo(ctx)).start();
 
        out.println("结束Servlet的时间：" + new Date() + ".");
        out.flush();
    }
}