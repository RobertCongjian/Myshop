package com.shop.my.service.before.Impl;

import com.shop.my.dao.IndexDao;
import com.shop.my.pojo.Goods;
import com.shop.my.service.before.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    private IndexDao indexDao = null;


    @Override
    public List<Map<String, Object>> getSaleOrder() {
        return indexDao.getSaleOrder();
    }

    @Override
    public List<Map<String, Object>> getFocusOrder() {
        return indexDao.getFocusOrder();
    }

    @Override
    public List<Map<String, Object>> selectNotice() {
        return indexDao.selectNotice();
    }

    @Override
    public List<Map<String, Object>> getLastedGoods(Goods goods) {
        return indexDao.getLastedGoods(goods);
    }

    @Override
    public Goods selectGoodsById(Integer id) {
        return indexDao.selectGoodsById(id);
    }

    @Override
    public List<Goods> search(String mykey) {
        return indexDao.search(mykey);
    }
}
