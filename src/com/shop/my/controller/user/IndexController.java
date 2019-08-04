package com.shop.my.controller.user;


import com.shop.my.pojo.Goods;
import com.shop.my.service.admin.AdminNoticeService;
import com.shop.my.service.admin.AdminTypeService;
import com.shop.my.service.before.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller

public class IndexController {

    @Autowired
    private IndexService indexService = null;

    @Autowired
    private AdminTypeService adminTypeService = null;

    @Autowired
    private AdminNoticeService adminNoticeService = null;

    /**
     * 首页
     */
    @RequestMapping("/before")
    public String before(Model model, HttpSession session, Goods goods) {
        System.out.println(indexService.getSaleOrder());
        session.setAttribute("goodsType", adminTypeService.getGoodsType());
        model.addAttribute("salelist", indexService.getSaleOrder());
        model.addAttribute("focuslist", indexService.getFocusOrder());
        model.addAttribute("noticelist", indexService.selectNotice());
        if(goods.getId() == null){
            goods.setId(0);
        }
        model.addAttribute("lastedlist", indexService.getLastedGoods(goods));
        return "before/index";

    }

    /**
     * 转到注册页面
     */
    @RequestMapping("/toRegister")
    public String toRegister(){
        return "before/register";
    }


    /**
     * 转到登录页面
     */
    @RequestMapping("/toLogin")
    public String toLogin() {
        return "before/login";
    }

    /**
     * 转到商品详情页
     */
    @RequestMapping("/goodsDetail")
    public String goodsDetail(Model model,Integer id) {
        model.addAttribute("goods", indexService.selectGoodsById(id));
        return "before/goodsdetail";
    }

    /**
     * 转到公告页面
     */
    @RequestMapping("/selectANotice")
    public String selectANotice(Model model,Integer id) {
        model.addAttribute("notice", adminNoticeService.selectANotice(id));
        return "admin/noticeDetail";
    }

    /**
     * 首页搜索
     */
    @RequestMapping("/search")
    public String search(Model model,String mykey) {

        List<Goods> list = indexService.search(mykey);
        model.addAttribute("searchlist", list);
        return "before/searchResult";
    }




}
