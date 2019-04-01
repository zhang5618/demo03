package com.kgz.service;

import com.kgz.pojo.User;

public interface IUserservice {
    int login(User user);



    int register(User user);
}
