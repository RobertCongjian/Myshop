package com.shop.my.dao;


import com.shop.my.pojo.Goods;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface AdminGoodsDao {
    public List<Goods> selectGoods(); //查询所有商品
    public List<Goods> selectAllGoodsByPage(@Param("start") Integer start,@Param("limit") Integer limit); //分页查询所有商品
    public int addGoods(Goods goods); //添加商品
    public Goods selectGoodsById(Integer id); //通过id查询商品
    public Integer deleteGoods(List<Integer> ids); //删除多个商品
    public Integer deleteAGoods(Integer id); //删除单个商品
    public Integer updateGoodsById(Goods goods);//通过id更新商品
    public List<Map<String, Object>> selectCartGoods(Integer id);
    public List<Map<String, Object>> selectFocusGoods(Integer id);
    public List<Map<String, Object>> selectOrderdetailGoods(Integer id);



}
