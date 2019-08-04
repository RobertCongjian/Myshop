package com.shop.my.controller.admin;


import com.shop.my.pojo.Goods;
import com.shop.my.pojo.GoodsType;
import com.shop.my.service.admin.AdminTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/adminType")
public class AdminTypeController extends BaseController {
    @Autowired
    private AdminTypeService adminTypeService;
    /**
     * 到添加类型页面
     */
    @RequestMapping("/toAddType")
    public String toAddType(Model model) {
        List<GoodsType> goodsTypeList = adminTypeService.getGoodsType();
        model.addAttribute("allTypes", goodsTypeList);
        return "admin/addType";
    }
    /**
     * 添加类型
     */
    @RequestMapping("/addType")
    public String addType(String typename,HttpSession session) {
         adminTypeService.addType(typename);
        //添加商品与修改商品页面使用
        session.setAttribute("goodsType", adminTypeService.getGoodsType());
        return "forward:toAddType";
    }


    @RequestMapping("/toDeleteType")
    public String toDeleteType(Model model){
        model.addAttribute("allTypes", adminTypeService.getGoodsType());
        return "admin/deleteType";
    }

    @RequestMapping("/deleteType")
    public String deleteType(Integer id,Model model){
        List<Goods> goods = adminTypeService.findGoodsByType(id);
        if(goods.size()>0){
            model.addAttribute("msg", "该类型有商品，不允许删除!");
            return "forward:toDeleteType";
        }
        if(adminTypeService.deleteType(id)>0){
            model.addAttribute("msg", "类型删除成功!");
        }
        return "forward:toDeleteType";
    }




}
