package com.example.feixue.dao.mysql;

import com.example.feixue.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {
    List<User> findByUsername(String username);//根据用户名查询
    List<User> findByUsernameAndPassword(String username, String password);//根据用户名密码查询
    User findByUserid(String userid);
}
