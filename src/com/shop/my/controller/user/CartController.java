package com.shop.my.controller.user;

import com.shop.my.service.before.CartService;
import com.shop.my.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/cart")
public class CartController extends BaseBeforeController{

    @Autowired
    private CartService cartService = null;

    /**
     * 关注商品
     */
    @RequestMapping("/focus")
    public String focus(Model model, Integer id, HttpSession httpSession){
        Map<String,Object> map = new HashMap<>();
        map.put("userId", MyUtil.getUserId(httpSession));
        map.put("goodsId", id);
        List<Map<String,Object>> list = cartService.isFocus(map);
        if(list.size()>0){
            model.addAttribute("msg", "已关注该商品");
        }else {
            int n = cartService.focus(map);
            if(n>0){
                model.addAttribute("msg", "成功关注该商品!");
            }else {
                model.addAttribute("msg", "关注失败！");
            }
        }
        return "forward:/goodsDetail?id=" + id;

    }


    /**
     * 添加购物车
     */
    @RequestMapping("/putCart")
    public String putCart(Integer shoppingnum,Integer id,HttpSession httpSession){
        Map<String,Object> map = new HashMap<>();
        map.put("userId", MyUtil.getUserId(httpSession));
        map.put("goodsId", id);
        map.put("shoppingnum", shoppingnum);

        List<Map<String,Object>> list = cartService.isPutCart(map);
        if(list.size()>0){
            cartService.updateCart(map);
        }else {
            cartService.putCart(map);
        }
        return "forward:selectCart";
    }

    /**
     * 查询购物车
     */
    @RequestMapping("/selectCart")
    public String selectCart(Model model,HttpSession httpSession){
        List<Map<String,Object>> list = cartService.selectCart(MyUtil.getUserId(httpSession));
        double sum = 0;
        for(Map<String,Object> map:list){
            sum = sum+(double)map.get("smallsum");
        }
        model.addAttribute("total", sum);
        model.addAttribute("cartlist",list);
        return "before/cart";

    }

    /**
     * 删除购物车
     */
    @RequestMapping("/deleteAgoods")
    public String deleteAgoods(Integer id,HttpSession httpSession){
        Map<String,Object> map = new HashMap<>();
        map.put("userId", MyUtil.getUserId(httpSession));
        map.put("goodsId", id);
        cartService.deleteAgoods(map);
        return "forward:selectCart";
    }

    /**
     * 清空购物车
     */
    @RequestMapping("/clear")
    public String clear(HttpSession httpSession){
        cartService.clear(MyUtil.getUserId(httpSession));
        return "forward:selectCart";

    }

    /**
     * 去结算
     */
    @RequestMapping("orderConfirm")
    public String orderConfirm(Model model,HttpSession httpSession){
        List<Map<String,Object>> list = cartService.selectCart(MyUtil.getUserId(httpSession));
        double sum = 0;
        for (Map<String, Object> map : list) {
            sum = sum + (Double)map.get("smallsum");
        }
        model.addAttribute("total", sum);
        model.addAttribute("cartlist", list);
        return "before/orderconfirm";

    }







}
