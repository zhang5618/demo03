package com.kgz.web;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

public class AServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String uid = UUID.randomUUID().toString();
        Cookie cookie = new Cookie("id", uid);
        Cookie cookie1 = new Cookie("b", "bb");
        //cookie.setMaxAge(60*2);
        //把cookie数据发送给浏览器保存，在每一次访问当前的时候
        response.addCookie(cookie);
        response.getWriter().print("cookie已经响应给你了");

    }
}
