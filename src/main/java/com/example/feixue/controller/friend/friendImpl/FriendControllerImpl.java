package com.example.feixue.controller.friend.friendImpl;

import com.example.feixue.bean.Friend;
import com.example.feixue.bean.FriendGroup;
import com.example.feixue.bean.User;
import com.example.feixue.controller.friend.FriendController;
import com.example.feixue.service.FriendService;
import com.example.feixue.service.GroupService;
import com.example.feixue.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FriendControllerImpl implements FriendController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private FriendService friendService;
    @Autowired
    private GroupService groupService;
    @Autowired
    private UserService userService;

    @Override
    public List<Friend> getFriendList(String groupId) {
        return friendService.getFriendsGroupId(groupId);
    }

    @Override
    public List<FriendGroup> getFriendGroup(String userId) {
        return groupService.getGroup(userId);
    }

    @Override
    public User getUserList(String userId) {
        return userService.getUser(userId);
    }

    @Override
    public FriendGroup addFriendFroup(String name, String userId) {
        String maxGroupId = groupService.getGroupId();
        FriendGroup friendGroup = new FriendGroup();
        friendGroup.setUserid(userId);
        friendGroup.setGroupid(String.format("%09d",Integer.valueOf(maxGroupId)+1));
        friendGroup.setGroupname(name);
        if(groupService.addGroup(friendGroup)){
            logger.info("分组名称:"+ friendGroup.getGroupname());
        }
        return friendGroup;
    }

    @Override
    public boolean deleteFriend(String userid, String groupId) {
        return friendService.deleteFriend(userid,groupId);
    }
}
