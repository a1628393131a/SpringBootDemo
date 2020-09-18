package com.example.feixue.service;

import com.example.feixue.bean.User;

import java.util.List;

public interface UserService {
    User getUser(String id);//主键查询
    List<User> getUsers(String name);
    List<User> getUsers();
    User getSave(User user);
    User getUser(User user);
    User getUser(String name, String password);
    void deleteUser(User user);
    User ifUser();
    void setUser(User user);//插入缓存
    User getUser();//读取缓存
    String getUserId();
    User addUser(User user);
}
