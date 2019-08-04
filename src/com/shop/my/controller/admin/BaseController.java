package com.shop.my.controller.admin;

import com.shop.my.exception.AdminLoginNoException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class BaseController {
    /**
     * 登录权限控制，处理方法执行前执行该方法
     * @throws AdminLoginNoException
     */
    @ModelAttribute
    public void isLogin(HttpSession session, HttpServletRequest request) throws AdminLoginNoException {
        System.out.println("isLogin");
        if(session.getAttribute("admin") == null){
            throw new AdminLoginNoException("没有登录");
        }
    }

    @ExceptionHandler(Exception.class)
    public String exception(HttpServletRequest request,Exception e){
        if(e instanceof AdminLoginNoException){
            if("没有登录".equals(e.getMessage())){
                request.setAttribute("msg", "没有登录，请先登录");
                return "admin/login";
            }
        }
        request.setAttribute("msg", e);
        return "error/error";
    }


}
