package com.shop.my.dao;


import com.shop.my.pojo.Goods;
import com.shop.my.pojo.GoodsType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminTypeDao {
	public List<GoodsType> selectGoodsType();
	public int addType(String typename);
	public int deleteType(Integer id);
	public List<Goods> selectGoodsByType(Integer id);
}
