package com.shop.my.dao;


import com.shop.my.pojo.Goods;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface IndexDao {
    public List<Map<String, Object>> getSaleOrder();
    public List<Map<String, Object>> getFocusOrder();
    public List<Map<String, Object>> selectNotice();
    public List<Map<String, Object>> getLastedGoods(Goods goods);
    public Goods selectGoodsById(Integer id);
    public List<Goods> search(String mykey);
}
