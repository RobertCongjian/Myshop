package com.shop.my.service.admin;

import com.shop.my.pojo.Notice;

import java.util.List;

public interface AdminNoticeService {
    public Integer addNotice(Notice notice);
    public List<Notice> selectNotices();
    public Integer deleteNotice(Integer id);
    public Notice selectANotice(Integer id);
}
