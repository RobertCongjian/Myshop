package com.shop.my.service.admin;

import java.util.List;
import java.util.Map;

public interface AdminOrderService {
    public List<Map<String,Object>> orderInfo();
    public Integer deleteOrderDetail(Integer id);
    public Integer deleteOrderBase(Integer id);
}
