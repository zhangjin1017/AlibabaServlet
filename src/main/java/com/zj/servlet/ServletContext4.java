package com.zj.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

@WebServlet(name = "ServletContext4", value = "/ServletContext4")
public class ServletContext4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext application=this.getServletContext();
        String path= this.getServletContext().getRealPath("/index.jsp");
        System.out.println(path);
        InputStream inputStream=this.getServletContext().getResourceAsStream("/index.jsp");
        Set<String> paths=this.getServletContext().getResourcePaths("/WEB-INF");
        System.out.println(paths);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
