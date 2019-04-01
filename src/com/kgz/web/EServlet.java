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
import java.io.PrintWriter;
import java.util.Map;

public class EServlet extends HttpServlet {
    IUserservice service = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //思路  1.取  2.调  3.存  4.转
        request.setCharacterEncoding("utf-8");//设置发送请求的格式
        response.setContentType("text/html;charset=UTF-8");//设置响应体的格式
        Map<String, String[]> map = request.getParameterMap();  //请求域 得到一个参数的集合！键值对形式
        User user = new User();  //创建一个user对象

        try {
            BeanUtils.populate(user,map);//导入bean工具类  将user封装进去!  此时user不是空对象  就有了用户名跟密码
            //调   调用service层
            int i= service.register(user);//将得到参数后的user传参进register方法  得到一个int类型的返回值！返回更改了多少行
            System.out.println("**"+i);
            if(i==1){//如果注册成功    进入登录页面   因为有主键  所以返回值只有可能是1或者报错
                response.getWriter().write("<script>alert('注册成功！')</script>");//弹框  提示注册成功   响应体
                //跳到登陆页面  重定向跟转发都不行，因为都不留响应体   所以用包含
                request.getRequestDispatcher("/jsp/login.jsp").include(request,response);//因为是服务器行为  直接写jsp下面的路径
            }
        } catch (Exception e) {
            //假如出现主键重复的情况  此时系统就会卡住不执行  不报错。若是将注册失败的代码放在finny里面  就会出现灯枯注册痛失出现的情况  因为用的包含
            //所以放在catch里面    出现主键重复的情况就跳转回注册页面
            response.getWriter().write("<script>alert('注册失败！')</script>");
            request.getRequestDispatcher("/jsp/register.jsp").include(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
