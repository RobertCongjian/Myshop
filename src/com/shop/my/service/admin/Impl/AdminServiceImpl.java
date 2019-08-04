package com.shop.my.service.admin.Impl;

import com.shop.my.dao.AdminDao;
import com.shop.my.pojo.Admin;
import com.shop.my.service.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;


@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao = null;


    @Override
    public Admin login(Admin admin) {
        return adminDao.login(admin);
    }
}
