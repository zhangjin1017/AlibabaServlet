package com.zj.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *  统计访问量
 * @author 1216916137
 */
@WebServlet(name = "ServletContext5", value = "/ServletContext5")
public class ServletContext5 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext application = this.getServletContext();
        Integer count = (Integer) application.getAttribute("count");
        if(count==null) {
            application.setAttribute("count", 1);
        }else {
            application.setAttribute("count", count + 1);
            PrintWriter pw = response.getWriter();
            pw.print("<h1>" + count + "</h1>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
