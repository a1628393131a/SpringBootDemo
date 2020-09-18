package com.example.feixue.controller.logical;

import com.example.feixue.bean.User;

/**
 * 登陆注册逻辑
 * Created by 浅忆 on 2019/5/24.
 */
public interface RegisterByLogOn {
    User logOn(User user);//登陆
    User Register(User user);//注册
    User getUser(User user);//用户密码查询
    void setUser(User user);//存储缓存
    User getUser();
}
