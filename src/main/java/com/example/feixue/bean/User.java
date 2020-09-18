package com.example.feixue.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 需求号码：
 * 需求名称：
 * 功能描述：用户表实体类
 *
 * @author 创建人 zrkwangye
 * @version 1.0
 * @Date 创建时间 2020/5/28 15:57
 */
@Entity
@Table(name = "user")
public class User implements Serializable {
    private static final long serialVersionUID = 6839815172664768378L;
    @Id
    private String userid;//用户账号
    @Column(nullable = false,unique = true)
    private String username;//用户名
    @Column(nullable = false,unique = true)
    private String password;//用户密码
    @Column(nullable = false,unique = true)
    private String sex;//性别
    @Column(nullable = false,unique = true)
    private String age;//年龄
    @Column(nullable = false,unique = true)
    private String phone;//电话
    @Column(nullable = false,unique = true)
    private String birthday;//出生日期

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid='" + userid + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", age='" + age + '\'' +
                ", phone='" + phone + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
