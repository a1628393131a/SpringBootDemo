package com.example.feixue.service.impl;

import com.example.feixue.bean.User;
import com.example.feixue.dao.mybatis.UserDao;
import com.example.feixue.dao.mysql.UserRepository;
import com.example.feixue.dao.rids.RidsUserDao;
import com.example.feixue.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 需求号码：
 * 需求名称：
 * 功能描述：用户服务实体类
 *
 * @author 创建人 zrkwangye
 * @version 1.0
 * @Date 创建时间 2020/5/28 16:23
 */
@Component
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(getClass());
    @Resource
    private RidsUserDao ridsUserDao;

    @Resource
    private UserDao userDao;

    @Resource
    private UserRepository userRepository;

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    @Override
    public User getUser(String id) {
        logger.info("查询id："+id);
        return userRepository.findById(id).get();
    }

    /**
     * 根据用户名查询
     * @param name
     * @return
     */
    @Override
    public List<User> getUsers(String name) {
        logger.info("查询name："+name);
        return userRepository.findByUsername(name);
    }

    /**
     *查询全部
     * @return
     */
    @Override
    public List<User> getUsers() {
        logger.info("查询全部");
        return userRepository.findAll();
    }

    /**
     * 插入修改
     * @param user
     * @return
     */
    @Override
    public User getSave(User user) {
        logger.info("操作"+user.getUsername());
        return userRepository.save(user);
    }

    public User addUser(User user){
        logger.info("id:"+user.getUserid());
        logger.info(""+userDao.addUser(user));
        return userRepository.findByUserid(user.getUserid());
    }

    @Override
    public User getUser(User user) {
        return null;
    }

    /**
     * 根据用户名密码查询
     * @param name
     * @param password
     * @return
     */
    @Override
    public User getUser(String name, String password) {
        logger.info("查询name："+name);
        List<User> users = userRepository.findByUsernameAndPassword(name,password);
        if (users != null && users.size()>0){
            return users.get(0);
        }
        return null;
    }

    /**
     * 删除用户
     * @param user
     */
    @Override
    public void deleteUser(User user) {
        logger.info("删除"+user.getUsername());
        userRepository.delete(user);
    }

    /**
     * 判断是否有缓存
     * @return
     */
    @Override
    public User ifUser() {
        User user = ridsUserDao.getUser();
        return user;
    }

    /**
     * 插入缓存
     * @param user
     */
    @Override
    public void setUser(User user) {
        ridsUserDao.setUser(user);
    }

    /**
     * 读取缓存
     * @return
     */
    @Override
    public User getUser() {
        return ridsUserDao.getUser();
    }

    @Override
    public String getUserId() {
        String userid = userDao.getUserId();
        return userid==null?"0":userid;
    }
}
