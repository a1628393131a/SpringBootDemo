package com.example.feixue.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 需求号码：
 * 需求名称：
 * 功能描述：好友表
 *
 * @author 创建人 zrkwangye
 * @version 1.0
 * @Date 创建时间 2020/5/30 18:55
 */
@Entity
@Table(name = "friend")
public class Friend implements Serializable{
    @Id
    private String groupid;//组ID
    @Column(nullable = true)
    private String friendid;//好友ID

    @Column(nullable = true)
    private String attention;//特别关心

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }

    public String getFriendid() {
        return friendid;
    }

    public void setFriendid(String friendid) {
        this.friendid = friendid;
    }

    public String getAttention() {
        return attention;
    }

    public void setAttention(String attention) {
        this.attention = attention;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "groupId='" + groupid + '\''+
                ", friendId='" + friendid + '\'' +
                ", attention='" + attention + '\'' +
                '}';
    }
}
