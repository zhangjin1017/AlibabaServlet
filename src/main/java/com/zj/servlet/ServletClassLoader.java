package com.zj.servlet;


import org.apache.commons.io.IOUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(name = "ServletClassLoader", value = "/ServletClassLoader")
public class ServletClassLoader extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClassLoader cl=this.getClass().getClassLoader();
        InputStream inputStream=cl.getResourceAsStream("a.txt");

        Class c=this.getClass();
        InputStream inputStream2=c.getResourceAsStream("/a.txt");


        Class c1=this.getClass();
        //建议使用ServletContext4中的getServletContext().getRealPath(）
        InputStream inputStream3=c1.getResourceAsStream("/../../index.jsp");

        String stream= IOUtils.toString(inputStream3);
        System.out.println(stream);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
