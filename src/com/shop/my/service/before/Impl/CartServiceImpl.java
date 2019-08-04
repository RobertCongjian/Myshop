package com.shop.my.service.before.Impl;

import com.shop.my.dao.CartDao;
import com.shop.my.service.before.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartDao cartDao = null;
    @Override
    public int focus(Map<String, Object> map) {
        return cartDao.focus(map);
    }

    @Override
    public List<Map<String, Object>> isFocus(Map<String, Object> map) {
        return cartDao.isFocus(map);
    }

    @Override
    public List<Map<String, Object>> isPutCart(Map<String, Object> map) {
        return cartDao.isPutCart(map);
    }

    @Override
    public int putCart(Map<String, Object> map) {
        return cartDao.putCart(map);
    }

    @Override
    public int updateCart(Map<String, Object> map) {
        return cartDao.updateCart(map);
    }

    @Override
    public List<Map<String, Object>> selectCart(Integer id) {
        return cartDao.selectCart(id);
    }

    @Override
    public int deleteAgoods(Map<String, Object> map) {
        return cartDao.deleteAgoods(map);
    }

    @Override
    public int clear(Integer id) {
        return cartDao.clear(id);
    }
}
