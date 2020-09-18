package com.example.feixue.dao.mybatis;

import com.example.feixue.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


/**
 * @author 16283
 */
@Repository
public interface UserDao {
    @Select("select max(userid) from user")
    String getUserId();
    @Insert({ "insert into user (userid,username,password,sex,age,phone,birthday) values(#{userid}, #{username},#{password}, #{sex}, #{age}, #{phone}, #{birthday})" })
    int addUser(User user);
}
