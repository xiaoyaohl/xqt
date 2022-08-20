package com.dream.xqt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import javax.annotation.ManagedBean;

/**
 * @author xinxiaoyao
 * @date 2022/6/1 17:23
 */
@Configuration
@SpringBootApplication
@ManagedBean
@MapperScan("com.")
public class StartApplication {
    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class);
    }
}
