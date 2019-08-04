package com.shop.my.service.admin;

import com.shop.my.pojo.Goods;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface AdminGoodsService {
    public Goods selectGoodsById(Integer id);
    public Integer deleteGoods(List<Integer> ids);
    public Integer deleteAGoods(Integer id);
    public Integer addGoods(Goods goods);
    public Integer updateGoodsById(Goods goods);
    public List<Goods> selectGoods();
    public List<Goods> selectAllGoodsByPage(Integer start,Integer limit);
    public List<Map<String, Object>> selectCartGoods(Integer id);
    public List<Map<String, Object>> selectFocusGoods(Integer id);
    public List<Map<String, Object>> selectOrderdetailGoods(Integer id);
}
