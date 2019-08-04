package com.shop.my.controller.admin;

import com.shop.my.service.admin.AdminOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/adminOrder")
public class AdminOrderController extends BaseController {
    @Autowired
    private AdminOrderService adminOrderService = null;

    @RequestMapping("/orderInfo")
    public String orderInfo(Model model){
        List<Map<String,Object>> list = adminOrderService.orderInfo();
        model.addAttribute("orderList", list);
        return "admin/orderManager";

    }

    @RequestMapping("deleteorderManager")
    public String deleteorderManager(Integer id){
        //先删除明细
        adminOrderService.deleteOrderDetail(id);
        //再删除订单基础
        adminOrderService.deleteOrderBase(id);
        return "forward:orderInfo";
    }
}
