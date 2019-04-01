package com.kgz.service.impl;

import com.kgz.dao.IUserDao;
import com.kgz.dao.impl.UserDaoImpl;
import com.kgz.pojo.User;
import com.kgz.service.IUserservice;

public class UserServiceImpl implements IUserservice {
    IUserDao dao = new UserDaoImpl();
    @Override
    public int login(User user) {
        return dao.login(user);
    }


    @Override
    public int register(User user) {
        return dao.register(user);
    }
}
