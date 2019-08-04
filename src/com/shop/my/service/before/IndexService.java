package com.shop.my.service.before;

import com.shop.my.pojo.Goods;

import java.util.List;
import java.util.Map;

public interface IndexService {
    public List<Map<String, Object>> getSaleOrder();
    public List<Map<String, Object>> getFocusOrder();
    public List<Map<String, Object>> selectNotice();
    public List<Map<String, Object>> getLastedGoods(Goods goods);
    public Goods selectGoodsById(Integer id);
    public List<Goods> search(String mykey);
}
