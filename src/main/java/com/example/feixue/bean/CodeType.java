package com.example.feixue.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 需求号码：
 * 需求名称：
 * 功能描述：码值表
 *
 * @author 创建人 zrkwangye
 * @version 1.0
 * @Date 创建时间 2020/5/30 17:05
 */
@Entity
@Table(name = "codetype")
public class CodeType implements Serializable {

    private static final long serialVersionUID = 683981517211768378L;

    @Id
    private String code;
    @Column(nullable = true)
    private String codetype;
    @Column(nullable = false)
    private String codename;
    @Column(nullable = false)
    private String codevalue;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCodetype() {
        return codetype;
    }

    public void setCodetype(String codetype) {
        this.codetype = codetype;
    }

    public String getCodename() {
        return codename;
    }

    public void setCodename(String codename) {
        this.codename = codename;
    }

    public String getCodevalue() {
        return codevalue;
    }

    public void setCodevalue(String codevalue) {
        this.codevalue = codevalue;
    }

    @Override
    public String toString() {
        return "CodeType{" +
                "code='" + code + '\'' +
                ", codeType='" + codetype + '\'' +
                ", codeName='" + codename + '\'' +
                ", codeValue='" + codevalue + '\'' +
                '}';
    }
}
