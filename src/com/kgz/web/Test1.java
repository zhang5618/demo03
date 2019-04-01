package com.kgz.web;

import java.awt.image.BufferedImage;
import java.io.FileOutputStream;

public class Test1 {
    public static void main(String[] args) throws Exception {
        // 创建验证码的对象
        VerifyCode vc = new VerifyCode();
        // 获取随机图片
        BufferedImage image = vc.createImage();
        // 获取刚刚生成的随机图片上的文本
        String text = vc.getText();
        System.out.println(text);
        // 保存图片到E盘
        FileOutputStream out = new FileOutputStream("E:/xxx.jpg");
        //写到输出流中去
        VerifyCode.output(image, out);

    }
}
