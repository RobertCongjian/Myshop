package com.shop.my.service.before;

import java.util.List;
import java.util.Map;

public interface UserCenterService {
    public List<Map<String, Object>> myOrder(Integer id);
    public List<Map<String, Object>> myFocus(Integer id);
    public List<Map<String, Object>> orderDetail(Integer ordersn);
}
