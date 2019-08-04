package com.shop.my.service.admin.Impl;

import com.shop.my.dao.AdminOrderDao;
import com.shop.my.service.admin.AdminOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AdminOrderServiceImpl implements AdminOrderService {

    @Autowired
    private AdminOrderDao adminOrderDao = null;
    @Override
    public List<Map<String, Object>> orderInfo() {
        return adminOrderDao.orderInfo();
    }

    @Override
    public Integer deleteOrderDetail(Integer id) {
        return adminOrderDao.deleteOrderDetail(id);
    }

    @Override
    public Integer deleteOrderBase(Integer id) {
        return adminOrderDao.deleteOrderBase(id);
    }
}
