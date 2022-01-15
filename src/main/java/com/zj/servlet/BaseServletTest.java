package com.zj.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * @author 1216916137
 */
@WebServlet(name = "BaseServletTest", value = "/BaseServletTest")
public class BaseServletTest extends BaseServlet {
    public String fun1(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
        System.out.println("fun1()...");
        return  "/index.jsp";
    }
    public String fun2(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
        System.out.println("fun2()...");
        return  "r:/index.jsp";
    }
    public String fun3(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
        System.out.println("fun3()...");
        return  "d:/a.txt";
    }
    public String fun4(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
        System.out.println("fun3()...");
        return  null;
    }
}
