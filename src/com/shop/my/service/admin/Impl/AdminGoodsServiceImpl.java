package com.shop.my.service.admin.Impl;

import com.shop.my.dao.AdminGoodsDao;
import com.shop.my.pojo.Goods;
import com.shop.my.service.admin.AdminGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AdminGoodsServiceImpl implements AdminGoodsService {

    @Autowired
    private AdminGoodsDao adminGoodsDao = null;

    @Override
    public Goods selectGoodsById(Integer id){
        return adminGoodsDao.selectGoodsById(id);
    }

    @Override
    public Integer deleteGoods(List<Integer> ids){
        return adminGoodsDao.deleteGoods(ids);
    }

    @Override
    public Integer deleteAGoods(Integer id){
        return adminGoodsDao.deleteAGoods(id);
    }

    @Override
    public Integer addGoods(Goods goods) {
        return adminGoodsDao.addGoods(goods);
    }

    @Override
    public Integer updateGoodsById(Goods goods) {
        return adminGoodsDao.updateGoodsById(goods);
    }

    @Override
    public List<Goods> selectGoods(){
        return adminGoodsDao.selectGoods();
    }

    @Override
    public List<Goods> selectAllGoodsByPage(Integer start, Integer limit) {
        return adminGoodsDao.selectAllGoodsByPage(start, limit);
    }

    @Override
    public List<Map<String, Object>> selectCartGoods(Integer id) {
        return adminGoodsDao.selectCartGoods(id);
    }

    @Override
    public List<Map<String, Object>> selectFocusGoods(Integer id) {
        return adminGoodsDao.selectFocusGoods(id);
    }

    @Override
    public List<Map<String, Object>> selectOrderdetailGoods(Integer id) {
        return adminGoodsDao.selectOrderdetailGoods(id);
    }
}
