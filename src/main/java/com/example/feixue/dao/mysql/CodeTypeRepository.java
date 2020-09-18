package com.example.feixue.dao.mysql;

import com.example.feixue.bean.CodeType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 16283
 */
public interface CodeTypeRepository extends JpaRepository<CodeType, String> {
    CodeType findByCodetypeAndCodevalue(String codetype, String Codevalue);
}
