package com.shop.my.dao;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public interface CartDao {
    public int focus(Map<String, Object> map);
    public List<Map<String, Object>> isFocus(Map<String, Object> map);
    public List<Map<String, Object>> isPutCart(Map<String, Object> map);
    public int putCart (Map<String, Object> map);
    public int updateCart (Map<String, Object> map);
    public List<Map<String, Object>> selectCart(Integer id);
    public int deleteAgoods (Map<String, Object> map);
    public int clear(Integer id);
}
