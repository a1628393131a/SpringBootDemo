package com.example.feixue.dao.mysql;

import com.example.feixue.bean.FriendGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupRepository extends JpaRepository<FriendGroup, String> {
    List<FriendGroup> findByUserid(String userId);
    FriendGroup findByGroupidAndUserid(String groupId, String userId);
}
