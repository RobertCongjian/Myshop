package com.shop.my.dao;

import com.shop.my.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    public Integer register(User user);
    public List<User> login(User user);
}
