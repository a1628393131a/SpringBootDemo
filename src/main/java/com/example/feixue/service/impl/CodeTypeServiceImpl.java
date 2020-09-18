package com.example.feixue.service.impl;

import com.example.feixue.bean.CodeType;
import com.example.feixue.dao.mysql.CodeTypeRepository;
import com.example.feixue.service.CodeTypeService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 需求号码：
 * 需求名称：
 * 功能描述：码值查询
 *
 * @author 创建人 zrkwangye
 * @version 1.0
 * @Date 创建时间 2020/5/30 17:12
 */
@Component
public class CodeTypeServiceImpl implements CodeTypeService {
    @Resource
    private CodeTypeRepository codeTypeRepository;

    @Override
    public CodeType getCode(String codeType, String CodeValue) {
        return codeTypeRepository.findByCodetypeAndCodevalue(codeType,CodeValue);
    }
}
