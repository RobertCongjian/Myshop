package com.shop.my.dao;

import com.shop.my.pojo.Notice;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminNoticeDao {
    public Integer addNotice(Notice notice);
    public List<Notice> selectNotices();
    public Integer deleteNotice(Integer id);
    public Notice selectANotice(Integer id);
}
