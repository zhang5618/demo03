package com.kgz.web;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
       /* Cookie[] cs = request.getCookies();
        for (Cookie c:cs){//输出request对象中名称为jsessionid的cookie值
            if (c.getName().equalsIgnoreCase("JSESSIONID")){
                System.out.println(c.getValue());
            }
            System.out.println();
        }*/

        response.setContentType("text/html;charset=UTF-8");//设置响应对象的格式并且告诉浏览器以什么格式解析
        //思路： 1.获取请求参数  2.将用户名存进session域对象中   3.重定向到login1.jsp中
        String name = request.getParameter("name");
        String psw = request.getParameter("psw");
        if (name.equals("王璟")){//如果用户输入的用户名是课工场的话 ，就把这个用户名存到session域对象中
            //新建一个session时  会response.addnew Cookie("JSESSIONID",UUID.randomUUID())
            HttpSession session = request.getSession();
            session.setAttribute("name",name);//相当于一个键值对
            session.setAttribute("psw",psw);
            session.setMaxInactiveInterval(5);
        }

        response.sendRedirect("/cookie/login1.jsp");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
