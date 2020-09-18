package com.example.feixue.controller.ridsGetSet;

import com.example.feixue.bean.User;
import com.example.feixue.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class RidsGetSet {
    @Resource
    private UserService userService;
    public User getUser() {
        return userService.getUser();
    }
}
