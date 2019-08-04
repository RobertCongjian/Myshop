package com.shop.my.service.admin.Impl;


import com.shop.my.dao.AdminTypeDao;
import com.shop.my.pojo.Goods;
import com.shop.my.pojo.GoodsType;
import com.shop.my.service.admin.AdminTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class AdminTypeServiceImpl implements AdminTypeService {
    @Autowired
    private AdminTypeDao adminTypeDao;

    @Override
    public List<GoodsType> getGoodsType() {
        return adminTypeDao.selectGoodsType();
    }

    @Override
    public int addType(String typename) {
        return adminTypeDao.addType(typename);
    }

    @Override
    public int deleteType(Integer id) {
        return adminTypeDao.deleteType(id);
    }

    @Override
    public List<Goods> findGoodsByType(Integer id) {
        return adminTypeDao.selectGoodsByType(id);
    }
}
