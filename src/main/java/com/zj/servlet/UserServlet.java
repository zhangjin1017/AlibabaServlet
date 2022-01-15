package com.zj.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;


/**
 * 空指针异常  未知错误 BaseServletTest中可以成功测试
 * @author 1216916137
 */
@WebServlet(name = "UserServlet", value = "/UserServlet")
public class UserServlet extends BaseServlet {


    public void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("addUser()...");
//        request.getRequestDispatcher("/xxx").forward(request, response);
//        response.sendRedirect(request.getContextPath()+"/xxx.jsp");
    }
    public void editUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("editUser()...");
    }
    public void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("deleteUser()...");
    }
}
