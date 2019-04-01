package com.kgz.web;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        Cookie[] cs = request.getCookies();//获取请求中所有的cookie

        if (cs!=null){
            for (Cookie cc:cs){
                String name = cc.getName();
                if (name.equals("id")){
                    response.getWriter().write("你的name为id的值是"+cc.getValue());
                }
            }
        }

    }
}
