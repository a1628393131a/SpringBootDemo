package com.example.feixue.controller.friend;

import com.example.feixue.bean.Friend;
import com.example.feixue.bean.FriendGroup;
import com.example.feixue.bean.User;

import java.util.List;

/**
 * 好友页面逻辑
 */
public interface FriendController {
        List<Friend> getFriendList(String groupId);
        List<FriendGroup> getFriendGroup(String userId);
        User getUserList(String userId);
        FriendGroup addFriendFroup(String name, String userId);
        boolean deleteFriend(String userid, String groupId);
}
