package com.example.feixue.view;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.example.feixue.bean.User;
import com.example.feixue.controller.logical.RegisterByLogOn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * 主页服务(提供登陆和注册功能)
 * Created by 浅忆 on 2019/5/24.
 */
@RestController
@RequestMapping(value = "/indexView")
public class Index {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private RegisterByLogOn registerByLogOn;


    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String getUser(@RequestBody String userJson) {
        logger.info("登陆判断");
        User user = JSON.parseObject(userJson, User.class);
        user = registerByLogOn.logOn(user);
        if (user != null && !StringUtils.isEmpty(user.getUsername()) && !StringUtils.isEmpty(user.getPassword())) {
            registerByLogOn.setUser(user);
        } else {
            return "false";
        }
        return "true";
    }

    @RequestMapping(value = "/get")
    public String getUser(ModelMap model) {
        logger.info("进入注册页面");
        User user = registerByLogOn.getUser();
        model.addAttribute("user", user);
        return "getUser";
    }

    @RequestMapping(value = "/set")
    public String setUser(ModelMap model) {
        logger.info("进入注册页面");
        User user = new User();
        model.addAttribute("user", user);
        return "setUser";
    }

    @RequestMapping(value = "/setUser")
    public String setUser(@RequestBody String userJson) {
        logger.info("正在注册");
        User user = JSON.parseObject(userJson, User.class);
        user = registerByLogOn.Register(user);
        return JSON.toJSONString(user);
    }
}
