package com.kgz.dao;

import com.kgz.pojo.User;

public interface IUserDao {
    int login(User user);

    int register(User user);
}
