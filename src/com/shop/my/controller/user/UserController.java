package com.shop.my.controller.user;


import com.shop.my.pojo.User;
import com.shop.my.service.before.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService = null;

    @RequestMapping("/register")
    public String register(User user, Model model, HttpSession httpSession,String code){
        System.out.println(user.getUemail()+code);
        if(!code.equalsIgnoreCase(httpSession.getAttribute("code").toString())){
            model.addAttribute("codeError","验证码错误！");
            return "before/register";
        }
        if(userService.register(user)>0){
            return "before/login";
        }else {
            model.addAttribute("msg", "注册失败!");
            return "before/register";
        }
    }

    @RequestMapping("/login")
    public String login(User user,Model model,HttpSession httpSession,String code){
        if(!code.equalsIgnoreCase(httpSession.getAttribute("code").toString())){
            model.addAttribute("msg", "验证码错误！");
            return "before/login";
        }
        User user1 = null;
        List<User> list = userService.login(user);
        if(list.size()>0){
            user1 = list.get(0);
        }
        if(user1!=null){
            httpSession.setAttribute("userOnline", user1);
            return "forward:/before";
        }else {
            model.addAttribute("msg", "用户名或密码错误！");
            return "before/login";
        }


    }

    @RequestMapping("/exit")
    public String exit(HttpSession session) {
        session.invalidate();
        return "forward:/before";
    }

}
