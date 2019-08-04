package com.shop.my.service.admin.Impl;

import com.shop.my.dao.AdminUserDao;
import com.shop.my.pojo.User;
import com.shop.my.service.admin.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminUserServiceImpl implements AdminUserService {
    @Autowired
    private AdminUserDao adminUserDao = null;

    @Override
    public List<User> userInfo() {
        return adminUserDao.userInfo();
    }

    @Override
    public Integer deleteuserManager(Integer id) {
        return adminUserDao.deleteuserManager(id);
    }
}
