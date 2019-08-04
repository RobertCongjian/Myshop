package com.shop.my.dao;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface AdminOrderDao {
    public List<Map<String,Object>> orderInfo();
    public Integer deleteOrderDetail(Integer id);
    public Integer deleteOrderBase(Integer id);
}
