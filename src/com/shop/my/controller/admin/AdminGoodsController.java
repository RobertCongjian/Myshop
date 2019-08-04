package com.shop.my.controller.admin;

import com.shop.my.pojo.Goods;
import com.shop.my.service.admin.AdminGoodsService;
import com.shop.my.util.MyUtil;
import org.apache.tools.ant.types.FileList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("adminGoods")
public class AdminGoodsController extends BaseController {
    @Autowired
    private AdminGoodsService adminGoodsService = null;

    @RequestMapping("/toAddGoods")
    public String toAddGoods() {
        return "admin/addGoods";
    }

    /**
     * 添加与修改
     */
    @RequestMapping("/addGoods")
    public String addGoods(Goods goods, @RequestParam(value = "multipartFile", required = false) MultipartFile multipartFile, String updateAct, HttpServletRequest request) {

        String newFileName = "";
        String fileName = multipartFile.getOriginalFilename();
        if (fileName.length() > 0) {
            String realPath = request.getServletContext().getRealPath("fileUpload");
            System.out.println(realPath);
            String fileType = fileName.substring(fileName.lastIndexOf("."));
            newFileName = MyUtil.getStringID() + fileType;
            goods.setGpicture(newFileName);
            File targetFile = new File(realPath, newFileName);
            if (!targetFile.exists()) {
                targetFile.mkdir();
            }
            try {
                multipartFile.transferTo(targetFile);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        if ("update".equals(updateAct)) {//如果有这个传过来，说明是修改操作
            //修改到数据库
            if (adminGoodsService.updateGoodsById(goods) > 0) {
                return "forward:selectGoods?act=updateSelect";
            } else {
                return "/admin/updateAGoods";
            }

        } else {//增添操作
            System.out.println(goods.getGname());
            if (adminGoodsService.addGoods(goods) > 0) {
//转发到查询的controller
                return "forward:selectGoods";
            } else {
                return "card/addCard";
            }

        }
    }

    /**
     * 查询操作
     * @param model 用来存储查询的结果
     * @param pageCur 分页查询使用，表明这是第几页
     * @param act 表明查询的类型，以便跳到相应的页面执行对应的操作
     * @return
     */
    @RequestMapping("selectGoods")
    public String selectGoods(Model model, Integer pageCur, String act) {
        List<Goods> allGoods = adminGoodsService.selectGoods();
        int size = allGoods.size();
        model.addAttribute("totalCount", size);
        int totalPage;
        if (size == 0) {
            totalPage = 0;
        } else {
            //计算有多少页，往上取整
            totalPage = (int) Math.ceil((double) size / 10);
        }
        if (pageCur == null) {
            pageCur = 1;
        }
        if ((pageCur - 1) * 10 > size) {
            pageCur = pageCur - 1;
        }

        //分页查询
        allGoods = adminGoodsService.selectAllGoodsByPage((pageCur - 1) * 10, 10);
        model.addAttribute("allGoods", allGoods);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("pageCur", pageCur);

        //删除查询
        if ("deleteSelect".equals(act)) {
            return "admin/deleteSelectGoods";
        }
        //修改查询
        else if ("updateSelect".equals(act)) {
            return "admin/updateSelectGoods";
        } else {
            return "admin/selectGoods";
        }
    }

    /**
     * 查询一个名片
     */
    @RequestMapping("/selectAGoods")
    public String selectAGoods(Model model, Integer id, String act){
        Goods agoods = adminGoodsService.selectGoodsById(id);
        model.addAttribute("goods", agoods);
        //如果是修改跳转到修改页面
        if("updateAgoods".equals(act)){
            return "admin/updateAGoods";
        }
        //跳到详情页面
        return "admin/goodsDetail";
    }

    /**
     * 删除单个商品
     */
    @RequestMapping("/deleteAGoods")
    public String deleteAGoods(Integer id, Model model) {
        //商品有关联
        if(adminGoodsService.selectCartGoods(id).size()>0
                ||adminGoodsService.selectFocusGoods(id).size()>0
                ||adminGoodsService.selectOrderdetailGoods(id).size()>0){
            model.addAttribute("msg", "商品存在关联，不允许删除");
            return "forward:selectGoods?act=deleteSelect";
        }
        adminGoodsService.deleteAGoods(id);
        model.addAttribute("msg", "成功删除商品");
        return "forward:selectGoods?act=deleteSelect";
    }

    /**
     * 删除多个商品
     */
    @RequestMapping("/deleteGoods")
    public String deleteGoods(Integer ids[], Model model) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i<ids.length;i++){
            //商品有关联
            if(adminGoodsService.selectCartGoods(ids[i]).size() > 0 ||
                    adminGoodsService.selectFocusGoods(ids[i]).size() > 0 ||
                    adminGoodsService.selectOrderdetailGoods(ids[i]).size() > 0) {
                model.addAttribute("msg", "商品有关联，不允许删除！");
                return "forward:selectGoods?act=deleteSelect";
            }
            list.add(ids[i]);
        }
        adminGoodsService.deleteGoods(list);
        model.addAttribute("msg", "成功删除商品");
        return "forward:selectGoods?act=deleteSelect";
    }

}
