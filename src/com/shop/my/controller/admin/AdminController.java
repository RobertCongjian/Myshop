package com.shop.my.controller.admin;

import com.shop.my.pojo.Admin;
import com.shop.my.service.admin.AdminService;
import com.shop.my.service.admin.AdminTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;


@Controller
public class AdminController {
    @Autowired
    private AdminService adminService = null;

    @Autowired
    private AdminTypeService adminTypeService = null;


    //页面初始化
    @RequestMapping("/admin")
    public String toLogin(@ModelAttribute Admin admin) {
        System.out.println("toLogin");
        return "admin/login";
    }

    @RequestMapping("/admin/login")
    public String login(@ModelAttribute Admin admin, Model model, HttpSession session) {
        System.out.println("login");
        Admin admins = adminService.login(admin);
        if(admins!=null){
            session.setAttribute("admin", admins);
            //添加商品与修改商品页面使用
            session.setAttribute("goodsType", adminTypeService.getGoodsType());
            return "admin/main";
        }
        model.addAttribute("msg", "密码或账号错误");
        return "admin/login";
    }

    @RequestMapping("/exit")
    public String exit(@ModelAttribute Admin admin, HttpSession session) {
        session.invalidate();
        return "admin/login";
    }


}
