package com.kgz.web;

import com.test.CookieUtil;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

public class GoodServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String goodName = request.getParameter("name");//先得到表单里面的name  定义为goodname
        //2.response对象写回去   重定向 a.jsp

        String goods = CookieUtil.getValue(request, "goods");//判断cookie中是否已经有值  返回value值
        if (goods!=null){ //第二次访问
            String[] arr = goods.split(",");//值   thinkpad  acer...split方法将goods转换成字符串形式得数组以，区分开来
            //将字符串数组变成一个集合
            HashSet<String> set = new HashSet<>(Arrays.asList(arr));////Arrays.asList(arr)  转换成list集合
            //添加第二次点击超链接参数中的值 装进set集合中  set集合能去重！ 参数（也就是商品的名称）
            set.add(goodName);

            goods = set.toString();//将set集合中所有的元素转换成一个字符串
            goods = goods.substring(1,goods.length()-1);//去掉集合变成字符串后两端的[]
            goods = goods.replace(",", "#");//替换，
            goods = goods.replace(" ","");//替换空格

        }else {//第一次去访问当前servlet
            goods=goodName;
        }
        //将这些浏览过的商品放到一个叫做goods的cookie里面存起来--Cooke key:goods  value:ThinkPad...
        Cookie c = new Cookie("goods", goods);
        c.setMaxAge(60*60);
        response.addCookie(c);
        response.sendRedirect("/jsp/a.jsp");//重定向  得到cookie后继续跳转到a.jsp

    }
}
