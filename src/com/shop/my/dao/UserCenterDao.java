package com.shop.my.dao;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public interface UserCenterDao {
    public List<Map<String, Object>> myOrder(Integer id);
    public List<Map<String, Object>> myFocus(Integer id);
    public List<Map<String, Object>> orderDetail(Integer ordersn);
}
