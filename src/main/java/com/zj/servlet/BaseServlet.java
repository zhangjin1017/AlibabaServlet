package com.zj.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.rmi.RemoteException;


/**
 * @author 1216916137
 */
public abstract class BaseServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String methodName=request.getParameter("method");
        if(methodName==null||methodName.trim().isEmpty()){
            throw  new RemoteException("没有传参");
        }

        Class c=this.getClass();
        Method method =null;
        try {
            //在调用私有方法时 必须用getDeclaredMethod，getDeclaredMethod和getMethod区别如下：
            //getMethod（只能获取public的方法）
            //getDeclaredMethod（能获取类中所有方法）
            method=c.getMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
        } catch (NoSuchMethodException e) {
//            throw  new RemoteException("调用的"+methodName+"(),不存在");
            e.printStackTrace();
        }
        //调用method表示的方法
        try {
           String result= (String) method.invoke(this,request,response);

            if (result == null||result.trim().isEmpty()) {
                return;
            }
            if (result.contains(":")) {
                int index = result.indexOf(":");
                String s1 = result.substring(0,index);
                String s2= result.substring(index+1);
                System.out.println("s1:"+s1);
                System.out.println("s2:"+s2);
                if (s1.equalsIgnoreCase("r")) {
                    response.sendRedirect(request.getContextPath()+s2);
                }else  if (s1.equalsIgnoreCase("f")) {

                    request.getRequestDispatcher(s2).forward(request, response);
                }else {
                    throw new RuntimeException("暂不支持:"+s1);
                }
            }else{
                System.out.println("result:"+result);
                request.getRequestDispatcher(result).forward(request, response);
            }

        } catch (IllegalAccessException | InvocationTargetException e) {
            System.out.println("调用的"+methodName+"(),内部出现异常");
            e.printStackTrace();
        }

        //不好用
//        String methodName=request.getParameter("method");
//        if("addUser".equals(methodName)){
//            addUser(request, response);
//        }else if ("editUser".equals(methodName)) {
//            editUser(request, response);
//        }else if ("deleteUser".equals(methodName)) {
//            deleteUser(request, response);
//        }



    }
}
