package com.shop.my.controller.user;



import com.shop.my.exception.UserLoginNoException;
import com.shop.my.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class BaseBeforeController {
    /**
     * 前台用户登录权限控制，处理方法执行前执行该方法
     *
     * @throws UserLoginNoException
     */
    @ModelAttribute
    public void isLogin(HttpSession session) throws UserLoginNoException {
        User user = (User) session.getAttribute("userOnline");
        if (user == null) {
            System.out.println("没有登录");
            throw new UserLoginNoException("没有登录");
        }


    }

    //异常处理，使得被拦截的控制器方法发生异常时发生对应响应
    @ExceptionHandler(Exception.class)
    public String exception(HttpServletRequest request,Exception e){
        if(e instanceof UserLoginNoException){
            if("没有登录".equals(e.getMessage())){
                request.setAttribute("msg", "没有登录，请先登录");
                return "before/login";
            }
        }
        request.setAttribute("msg", e);
        return "error/error";
    }


}

