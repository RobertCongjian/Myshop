package com.shop.my.controller.admin;

import com.shop.my.pojo.Notice;
import com.shop.my.service.admin.AdminNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/adminNotice")
public class AdminNoticeController extends BaseController {

    @Autowired
    private AdminNoticeService adminNoticeService = null;

    @RequestMapping("/toAddNotice")
    public String toAddNotice() {
        return "admin/addNotice";
    }

    @RequestMapping("/addNotice")
    public String addNotice(Notice notice){
        adminNoticeService.addNotice(notice);
        return "forward:deleteNoticeSelect";
    }

    @RequestMapping("/deleteNoticeSelect")
    public String deleteNoticeSelect(Model model){
        model.addAttribute("allNotices", adminNoticeService.selectNotices());
        return "admin/deleteNoticeSelect";
    }

    @RequestMapping("/selectANotice")
    public String selectANotice(Integer id,Model model){
        model.addAttribute("notice", adminNoticeService.selectANotice(id));
        return "admin/noticeDetail";
    }

    @RequestMapping("/deleteNotice")
    public String deleteNotice(Integer id){
        adminNoticeService.deleteNotice(id);
        return "forward:deleteNoticeSelect";

    }




}
