package com.kgz.web;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //第一次访问的时候  讲访问的时间转换为string类型  作为一个cookie。利用response对象响应给浏览器
        response.setContentType("text/html;charset=utf-8");
        /*String s = new Date().toLocaleString();
        String s1 = s.replaceAll(" ", "");
        System.out.println(s1);*/
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Cookie c = new Cookie("lasttime",format.format(new Date()));
        response.addCookie(c);
        //默认值是第一次访问
        String msg = "第一次访问有惊喜哦，亲";
        //第二次访问的时候 ,就可以取出request对象中的cookie
        Cookie[] cs = request.getCookies();
        if (cs!=null){
            for (Cookie co:cs){
                if (co.getName().equals("lasttime")){//之前的cookie都会带过来  所以做一个判断  只取出想要的cookie
                    msg="您上次访问的时间是："+co.getValue();
                }
            }
        }
        response.getWriter().write(msg);
    }
}
