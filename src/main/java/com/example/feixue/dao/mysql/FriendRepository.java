package com.example.feixue.dao.mysql;

import com.example.feixue.bean.Friend;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FriendRepository extends JpaRepository<Friend, String> {
    List<Friend> findByGroupid(String groupid);
    List<Friend> findByFriendid(String friendid);
    boolean deleteByFriendidAndGroupid(String friendid, String groupid);
}
