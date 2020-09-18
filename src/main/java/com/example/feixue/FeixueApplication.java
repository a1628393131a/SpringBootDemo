package com.example.feixue;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 16283
 */
@RestController
@SpringBootApplication
@ServletComponentScan
@MapperScan("com.example.feixue.dao.mybatis")
public class FeixueApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeixueApplication.class, args);
    }

}
