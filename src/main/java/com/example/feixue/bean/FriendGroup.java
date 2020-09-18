package com.example.feixue.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 需求号码：
 * 需求名称：
 * 功能描述：分组表
 *
 * @author 创建人 zrkwangye
 * @version 1.0
 * @Date 创建时间 2020/6/4 17:14
 */
@Entity
@Table(name = "friendgroup")
public class FriendGroup implements Serializable{
    @Column(nullable = false)
    private String userid;
    @Id
    private String groupid;
    @Column(nullable = true)
    private String groupname;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    @Override
    public String toString() {
        return "FriendGroup{" +
                "userid='" + userid + '\'' +
                ", groupid='" + groupid + '\'' +
                ", groupname='" + groupname + '\'' +
                '}';
    }
}
