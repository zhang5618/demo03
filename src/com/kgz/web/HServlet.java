package com.kgz.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class HServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();//返回当前服务器缓存中的session对象，如果没有 创建一个
        String id = session.getId();//32位长度的字符串
        System.out.println(id);

        int s = session.getMaxInactiveInterval();
        System.out.println(s);//返回配置时间秒数
    }
}
