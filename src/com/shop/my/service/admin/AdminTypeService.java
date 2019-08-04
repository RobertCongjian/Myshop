package com.shop.my.service.admin;

import com.shop.my.pojo.Goods;
import com.shop.my.pojo.GoodsType;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface AdminTypeService {
    public List<GoodsType> getGoodsType();
    public int addType(String typename);
    public int deleteType(Integer id);
    public List<Goods> findGoodsByType(Integer id);



}
