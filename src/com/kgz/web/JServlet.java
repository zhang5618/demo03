package com.kgz.web;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class JServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码格式
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //得到用户名跟验证码的值
        String username = request.getParameter("username");
        String code = request.getParameter("code");
        //通过get方法中存在session域的验证码text文本  得到这个文本  强转位String类型
        String text = (String) request.getSession().getAttribute("text");
        if(text.equals(code)){
            response.getWriter().write("验证匹配");
            System.out.println("验证成功");
        }else {
            response.getWriter().write("验证不匹配");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 创建验证码类
        VerifyCode vc = new VerifyCode();
        // 获取随机图片
        BufferedImage image = vc.createImage();
        // 获取刚刚生成的随机图片上的文本
        String text = vc.getText();
        System.out.println(text);
        //图片上的文本存进session域中
        request.getSession().setAttribute("text",text);

        // 保存图片
        //FileOutputStream out = new FileOutputStream("F:/xxx.jpg");
        ServletOutputStream os = response.getOutputStream();
        VerifyCode.output(image, os);//将图片写进输出流

    }
}
