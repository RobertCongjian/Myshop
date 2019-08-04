package com.shop.my.dao;


import com.shop.my.pojo.Admin;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminDao {
    public Admin login(Admin admin);
}
