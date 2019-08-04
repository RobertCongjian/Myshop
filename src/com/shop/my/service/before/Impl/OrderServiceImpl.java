package com.shop.my.service.before.Impl;

import com.shop.my.dao.OrderDao;
import com.shop.my.pojo.Order;
import com.shop.my.service.before.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao = null;
    @Override
    public int addOrder(Order order) {
        return orderDao.addOrder(order);
    }

    @Override
    public int addOrderDetail(Map<String, Object> map) {
        return orderDao.addOrderDetail(map);
    }

    @Override
    public List<Map<String, Object>> selectGoodsShop(Integer uid) {
        return orderDao.selectGoodsShop(uid);
    }

    @Override
    public int updateStore(Map<String, Object> map) {
        return orderDao.updateStore(map);
    }

    @Override
    public int clear(Integer uid) {
        return orderDao.clear(uid);
    }

    @Override
    public int pay(Integer ordersn) {
        return orderDao.pay(ordersn);
    }
}
