package com.shop.my.controller.user;

import com.shop.my.service.before.UserCenterService;
import com.shop.my.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;


@Controller
public class UserCenterController extends BaseBeforeController {

    @Autowired
    private UserCenterService userCenterService;
    @RequestMapping("/userCenter")
    public String userCenter(HttpSession session, Model model) {
        model.addAttribute("myOrder", userCenterService.myOrder(MyUtil.getUserId(session)));
        model.addAttribute("myFocus", userCenterService.myFocus(MyUtil.getUserId(session)));
        return "before/userCenter";
    }
    @RequestMapping("/orderDetail")
    public String orderDetail(Model model, Integer ordersn) {
        model.addAttribute("myOrderDetail", userCenterService.orderDetail(ordersn));
        return "before/userOrderDetail";
    }

}
