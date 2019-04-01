package com.kgz.web;



import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class FServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = URLEncoder.encode("张三","utf-8");
        String value = URLEncoder.encode("灵魂工程师","utf-8");
        Cookie c = new Cookie(name, value);

        response.setContentType("text/html;charset=utf-8");
        response.addCookie(c);

        Cookie[] cs = request.getCookies();
        if (cs!=null){
            for (Cookie cc:cs){
                if (URLDecoder.decode(cc.getName(),"utf-8").equals("张三")){
                    String name1 = cc.getName();
                    String value1 = cc.getValue();
                    System.out.println(URLDecoder.decode(name1,"utf-8")+"--"+URLDecoder.decode(value1,"utf-8"));
                }

            }
        }

        //疑似不支持   演示不出来
      /*  Cookie c1 = new Cookie("a", "aa");
        c1.setPath("/servlet");
        Cookie c2 = new Cookie("b", "bb");
        c2.setPath("/servlet/jsp");
        c1.setMaxAge(60*60);
        response.addCookie(c1);
        c2.setMaxAge(60*60);
        response.addCookie(c2);

        Cookie[] cs = request.getCookies();
        if (cs!=null){
            for (Cookie c:cs){
                System.out.println(c.getName()+"--"+c.getValue());
            }
        }*/
    }
}
