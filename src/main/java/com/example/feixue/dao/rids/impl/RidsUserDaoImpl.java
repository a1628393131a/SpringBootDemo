package com.example.feixue.dao.rids.impl;

import com.example.feixue.bean.User;
import com.example.feixue.dao.rids.RidsUserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 用户缓存实体类
 * Created by 浅忆 on 2019/5/24.
 */
@Component
public class RidsUserDaoImpl implements RidsUserDao {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Resource
    private RedisTemplate<String, User> redisTemplate;
    @Override
    public void setUser(User user) {
        logger.info("记录user");
        redisTemplate.opsForValue().set("user",user);
    }

    @Override
    public User getUser() {
        User user = redisTemplate.opsForValue().get("user");
        logger.info("输出user"+user);
        return  user;
    }

    @Override
    public void deleUser(User user) {
        logger.info("删除user");
        redisTemplate.delete("user");
    }
}
