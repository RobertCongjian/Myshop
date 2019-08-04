package com.shop.my.service.before;

import com.shop.my.pojo.User;

import java.util.List;

public interface UserService {
    public Integer register(User user);
    public List<User> login(User user);
}
