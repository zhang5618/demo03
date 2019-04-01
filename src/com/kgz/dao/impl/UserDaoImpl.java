package com.kgz.dao.impl;

import com.kgz.dao.IUserDao;
import com.kgz.pojo.User;
import com.kgz.utils.C3p0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.*;
import java.util.List;

public class UserDaoImpl implements IUserDao {
    /*public static void main(String[] args) {
        UserDaoImpl qq = new UserDaoImpl();
        boolean b = qq.register("王璟", "123");
        System.out.println(b);
    }*/

    @Override
    public int register(User user) {
        QueryRunner qr=new QueryRunner(C3p0Util.getDs());//创建连接对象
        try {//执行sql语句  将user对象得到的名字跟密码传参进values   返回到调用register的一个int
            return qr.update("insert into admini values(?,?)",user.getUsername(),user.getPassword());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public int login(User user) {

        QueryRunner qr=new QueryRunner(C3p0Util.getDs());
        try {
            List<User> list = qr.query("select * from admini where username=? and password=?", new BeanListHandler<User>(User.class),
                    user.getUsername(), user.getPassword());
            return list.size();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    }

