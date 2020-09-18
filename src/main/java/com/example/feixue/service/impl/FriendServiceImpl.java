package com.example.feixue.service.impl;

import com.example.feixue.bean.Friend;
import com.example.feixue.dao.mysql.FriendRepository;
import com.example.feixue.service.FriendService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 需求号码：
 * 需求名称：
 * 功能描述：好友表服务类
 *
 * @author 创建人 zrkwangye
 * @version 1.0
 * @Date 创建时间 2020/5/30 19:06
 */
@Component
public class FriendServiceImpl implements FriendService {
    @Resource
    private FriendRepository friendRepository;

    @Override
    public List<Friend> getFriendsGroupId(String groupId) {
        return friendRepository.findByGroupid(groupId);
    }

    @Override
    public List<Friend> getFriendsFriendId(String friendId) {
        return friendRepository.findByFriendid(friendId);
    }

    @Override
    public boolean deleteFriend(String friendId, String groupId) {
        return friendRepository.deleteByFriendidAndGroupid(friendId,groupId);
    }
}
