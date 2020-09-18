package com.example.feixue.dao.rids;

import com.example.feixue.bean.User;

/**
 * 用户表Rids存储
 * Created by 浅忆 on 2019/5/24.
 */
public interface RidsUserDao {
    void setUser(User user);//添加缓存
    User getUser();//取得缓存
    void deleUser(User user);//删除缓存
}
