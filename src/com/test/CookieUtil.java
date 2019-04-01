package com.test;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieUtil {

    //获取请求对象中的某一个名称叫做cookiename的cookie值
    public static String getValue(HttpServletRequest request,String cookieName){
        Cookie[] cs = request.getCookies();
        if (cs!=null){
            for (Cookie c:cs){
                if (c.getName().equals(cookieName)){
                    return c.getValue();
                }
            }
        }
        return null;

    }
}
