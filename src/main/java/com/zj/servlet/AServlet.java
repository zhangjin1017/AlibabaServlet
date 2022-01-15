package com.zj.servlet;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author 1216916137
 */
public class AServlet implements Servlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init()...");

        System.out.println(config.getInitParameter("p1"));
        System.out.println(config.getInitParameter("p2"));

        Enumeration<String> enumeration= config.getInitParameterNames();
        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("service()...");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("destroy()...");
    }
}
