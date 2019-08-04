package com.shop.my.controller.user;


import com.shop.my.pojo.Order;
import com.shop.my.service.before.OrderService;
import com.shop.my.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/order")
@Repository
public class OrderController extends BaseBeforeController {

    @Autowired
    private OrderService orderService = null;

    /**
     * 提交订单
     */
    @RequestMapping("/orderSubmit")
    public String orderSubmit(Model model, HttpSession session, Double amount) {
        Order order = new Order();
        order.setAmount(amount);
        order.setUser_id(MyUtil.getUserId(session));

        //生成订单，并将主键返回order
        orderService.addOrder(order);
        //生成订单详情
        Map<String, Object> map = new HashMap<>();
        map.put("ordersn", order.getId());
        map.put("userId", MyUtil.getUserId(session));
        orderService.addOrderDetail(map);
        //更新商品库存
        //查询商品购买量，以便更新库存使用
        List<Map<String, Object>> list = orderService.selectGoodsShop(MyUtil.getUserId(session));
        //根据商品购买量更新库存
        for(Map<String,Object> map1:list){
            orderService.updateStore(map1);
        }

        //清空购物车
        orderService.clear(MyUtil.getUserId(session));
        model.addAttribute("ordersn", order.getId());
        return "before/orderdone";
    }

    /**
     * 支付订单
     */
    @RequestMapping("/pay")
    public String pay(Integer ordersn) {
        orderService.pay(ordersn);
        return "before/paydone";
    }

}
