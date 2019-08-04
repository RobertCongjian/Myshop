package com.shop.my.service.before.Impl;

import com.shop.my.dao.UserDao;
import com.shop.my.pojo.User;
import com.shop.my.service.before.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao = null;

    @Override
    public Integer register(User user) {
        return userDao.register(user);
    }

    @Override
    public List<User> login(User user) {
        return userDao.login(user);
    }
}
