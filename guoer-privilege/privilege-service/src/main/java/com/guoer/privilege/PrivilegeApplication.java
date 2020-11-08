package com.guoer.privilege;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ：penghs
 * @date ：Created in 2020/11/8 20:25
 * @description：
 * @version: 1.0.0
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.guoer.privilege.repostory.mapper"})
public class PrivilegeApplication {

    public static void main(String[] args) {

        SpringApplication.run(PrivilegeApplication.class, args);
    }
}
