package com.kgz.web;

import com.kgz.pojo.User;
import com.kgz.service.IUserservice;
import com.kgz.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class CServlet extends HttpServlet {
    IUserservice service = new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");//设置格式
        Map<String, String[]> map = request.getParameterMap();//得到map集合   键值对
        User user = new User();
        try {
            BeanUtils.populate(user,map);//将得到的键值对封装到user对象里面去
            int i=service.login(user);//传参  调用登陆方法
            if(i==1){//登陆成功
                response.getWriter().write("<script>alert('登录成功！')</script>");//弹框显示登陆成功
                request.getRequestDispatcher("/jsp/a.jsp").include(request,response);//跳转到a.jsp里面
            }else{
                response.getWriter().write("<script>alert('登录失败！')</script>");//登陆失败  跳转回登陆页面
                request.getRequestDispatcher("/jsp/login.jsp").include(request,response);

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

}
