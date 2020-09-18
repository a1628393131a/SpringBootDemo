package com.example.feixue.controller.logical.logicalImpl;

import com.example.feixue.bean.CodeType;
import com.example.feixue.bean.FriendGroup;
import com.example.feixue.bean.User;
import com.example.feixue.controller.logical.RegisterByLogOn;
import com.example.feixue.service.CodeTypeService;
import com.example.feixue.service.GroupService;
import com.example.feixue.service.UserService;
import com.example.feixue.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 登陆注册逻辑实现类
 * Created by 浅忆 on 2019/5/24.
 */
@Component
public class RegisterByLogOnImpl implements RegisterByLogOn {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Resource
    private UserService userService;
    @Resource
    private CodeTypeService codeTypeService;
    @Resource
    private GroupService groupService;

    @Override
    public User logOn(User user) {
        if(user ==null){
            logger.info("用户录入为空");
            return user;
        }
        user = userService.getUser(user.getUsername(),user.getPassword());
        if(user == null || "".equals(user.getUserid())){
            logger.info("查无此人");
            return user;
        }
        return user;
    }

    @Override
    public User Register(User user) {
        String maxUserId = userService.getUserId();
        user.setUserid(String.format("%09d",Integer.valueOf(maxUserId)+1));
        user.setAge(DateUtil.getAgent(user.getBirthday()));
        logger.info(user.toString());
        if (!"1".equals(user.getSex())&&!"2".equals(user.getSex())) {
            CodeType codeType = codeTypeService.getCode("sex", user.getSex());
            user.setSex(codeType.getCode());
        }
        user = userService.addUser(user);
        FriendGroup friendGroup = new FriendGroup();
        friendGroup.setUserid(user.getUserid());
        String maxGroupId = groupService.getGroupId();
        friendGroup.setGroupid(String.format("%09d",Integer.valueOf(maxGroupId)+1));
        friendGroup.setGroupname("我的好友");
        if(groupService.addGroup(friendGroup)){
            logger.info("分组名称:"+ friendGroup.getGroupname());
        }
        return user;
    }

    @Override
    public User getUser(User user) {
        return userService.getUser(user.getUsername(),user.getPassword());
    }

    @Override
    public void setUser(User user) {
        userService.setUser(user);
    }

    @Override
    public User getUser() {
        return userService.getUser();
    }
}
