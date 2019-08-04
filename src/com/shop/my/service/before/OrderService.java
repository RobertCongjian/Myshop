package com.shop.my.service.before;

import com.shop.my.pojo.Order;

import java.util.List;
import java.util.Map;

public interface OrderService {
    public int addOrder(Order order);
    public int addOrderDetail(Map<String, Object> map);
    public List<Map<String, Object>> selectGoodsShop(Integer uid);
    public int updateStore(Map<String, Object> map);
    public int clear(Integer uid);
    public int pay(Integer ordersn);
}
