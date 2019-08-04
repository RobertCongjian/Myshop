package com.shop.my.service.before.Impl;

import com.shop.my.dao.UserCenterDao;
import com.shop.my.service.before.UserCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserCenterServiceImpl implements UserCenterService {

    @Autowired
    private UserCenterDao userCenterDao = null;

    @Override
    public List<Map<String, Object>> myOrder(Integer id) {
        return userCenterDao.myOrder(id);
    }

    @Override
    public List<Map<String, Object>> myFocus(Integer id) {
        return userCenterDao.myFocus(id);
    }

    @Override
    public List<Map<String, Object>> orderDetail(Integer ordersn) {
        return userCenterDao.orderDetail(ordersn);
    }
}
