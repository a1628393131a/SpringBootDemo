package com.example.feixue.service;

import com.example.feixue.bean.FriendGroup;

import java.util.List;

public interface GroupService {
    List<FriendGroup> getGroup(String userId);
    boolean addGroup(FriendGroup friendGroup);
    String getGroupId();
}
