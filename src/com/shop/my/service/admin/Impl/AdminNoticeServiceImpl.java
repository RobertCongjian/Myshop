package com.shop.my.service.admin.Impl;

import com.shop.my.dao.AdminNoticeDao;
import com.shop.my.pojo.Notice;
import com.shop.my.service.admin.AdminNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminNoticeServiceImpl implements AdminNoticeService {

    @Autowired
    private AdminNoticeDao adminNoticeDao = null;

    @Override
    public Integer addNotice(Notice notice) {
        return adminNoticeDao.addNotice(notice);
    }

    @Override
    public List<Notice> selectNotices() {
        return adminNoticeDao.selectNotices();
    }

    @Override
    public Integer deleteNotice(Integer id) {
        return adminNoticeDao.deleteNotice(id);
    }

    @Override
    public Notice selectANotice(Integer id) {
        return adminNoticeDao.selectANotice(id);
    }
}
