package com.shop.my.controller.admin;

import com.shop.my.service.admin.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/adminUser")
@Controller
public class AdminUserController extends BaseController {

    @Autowired
    private AdminUserService adminUserService = null;

    @RequestMapping("/userInfo")
    public String userInfo(Model model){
        model.addAttribute("userList", adminUserService.userInfo());
        return "admin/userManager";

    }

    @RequestMapping("/deleteUserManager")
    public String deleteUserManager(Integer id,Model model){
        //用户有关联

        if(adminUserService.deleteuserManager(id)>0){
            model.addAttribute("msg", "成功删除用户");
        }
        return "forward:userInfo";
    }

}
