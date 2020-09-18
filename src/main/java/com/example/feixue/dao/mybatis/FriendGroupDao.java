package com.example.feixue.dao.mybatis;

import com.example.feixue.bean.FriendGroup;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


/**
 * @author 16283
 */
@Repository
public interface FriendGroupDao {
    @Insert({ "insert into friendgroup (userid,groupid,groupname) values(#{userid}, #{groupid},#{groupname})" })
    int addGroup(FriendGroup friendGroup);
    @Select("select max(GroupId) from friendgroup")
    String getGroupId();
}
