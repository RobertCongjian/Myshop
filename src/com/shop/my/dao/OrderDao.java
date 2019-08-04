package com.shop.my.dao;

import com.shop.my.pojo.Order;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface OrderDao {

    public int addOrder(Order order);
    public int addOrderDetail(Map<String, Object> map);
    public List<Map<String, Object>> selectGoodsShop(Integer uid);
    public int updateStore(Map<String, Object> map);
    public int clear(Integer uid);
    public int pay(Integer ordersn);

}
