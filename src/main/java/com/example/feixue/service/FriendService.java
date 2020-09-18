package com.example.feixue.service;

import com.example.feixue.bean.Friend;

import java.util.List;

public interface FriendService {
    List<Friend> getFriendsGroupId(String groupId);
    List<Friend> getFriendsFriendId(String friendId);
    boolean deleteFriend(String friendId, String groupId);
}
