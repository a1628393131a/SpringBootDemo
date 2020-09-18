package com.example.feixue.view;

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

    @RequestMapping(value = "/indexService")
    public String getIndex(ModelMap model) {
        logger.info("进入登陆页面");
        User user = new User();
        model.addAttribute("user", user);
        return "index";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String getUser(ModelMap model, User user) {
        logger.info("登陆判断");
        user = registerByLogOn.logOn(user);
        if (null != user && null != user.getUserid() && !user.getUserid().equals("")) {
            registerByLogOn.setUser(user);
            model.addAttribute("users", registerByLogOn.getUser(user));
            model.addAttribute("user2", registerByLogOn.getUser());
            return "friendIndex";
        } else {
            model.addAttribute("user", new User());
            return "index";
        }

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
    public String setUser(@RequestBody String user) {
        logger.info("正在注册");
        User userBean = JSON.parseObject(user, User.class);
        userBean = registerByLogOn.Register(userBean);
        return JSON.toJSONString(userBean);
    }
}
