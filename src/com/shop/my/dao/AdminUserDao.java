package com.shop.my.dao;

import com.shop.my.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminUserDao {
    public List<User> userInfo();
    public Integer deleteuserManager(Integer id);
}
