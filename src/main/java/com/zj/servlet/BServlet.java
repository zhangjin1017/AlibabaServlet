package com.zj.servlet;

import javax.servlet.*;
import java.io.IOException;

public class BServlet implements Servlet {
private ServletConfig config;
    @Override
    public void init(ServletConfig config) throws ServletException {
            this.config = config;
            init();
    }
    public void init(){

    }
    @Override
    public ServletConfig getServletConfig() {
        return this.config;
    }
    public ServletContext getServletContext() {
        return config.getServletContext();
    }


    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("每次梳理请求都会被执行");
    }

    @Override
    public String getServletInfo() {
        return "我是一个快了的Servlet";
    }

    @Override
    public void destroy() {
        System.out.println("要销毁了");
    }
}
