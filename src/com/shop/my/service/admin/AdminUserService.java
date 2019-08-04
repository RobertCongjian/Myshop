package com.shop.my.service.admin;

import com.shop.my.pojo.User;

import java.util.List;

public interface AdminUserService {
    public List<User> userInfo();
    public Integer deleteuserManager(Integer id);
}
