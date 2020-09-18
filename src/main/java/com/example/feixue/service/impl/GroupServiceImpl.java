package com.example.feixue.service.impl;

import com.example.feixue.bean.FriendGroup;
import com.example.feixue.dao.mybatis.FriendGroupDao;
import com.example.feixue.dao.mysql.GroupRepository;
import com.example.feixue.service.GroupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 需求号码：
 * 需求名称：
 * 功能描述：分组服务类
 *
 * @author 创建人 zrkwangye
 * @version 1.0
 * @Date 创建时间 2020/6/4 17:21
 */
@Component
public class GroupServiceImpl implements GroupService{
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Resource
    private GroupRepository groupRepository;
    @Resource
    private FriendGroupDao friendGroupDao;

    @Override
    public List<FriendGroup> getGroup(String userId) {
        return groupRepository.findByUserid(userId);
    }

    @Override
    public boolean addGroup(FriendGroup friendGroup) {
        if (1 == friendGroupDao.addGroup(friendGroup)) {
            logger.info("保存成功");
            return true;
        }
        logger.info("保存失败");
        return false;
    }

    @Override
    public String getGroupId() {
        String groupid = friendGroupDao.getGroupId();
        return groupid==null?"0":groupid;
    }


}
