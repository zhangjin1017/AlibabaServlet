package com.zj.servlet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class DServlet extends GenericServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("我出生了...");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("hello world");
    }

    @Override
    public void destroy() {
        System.out.println("destroy()...");
    }
}
