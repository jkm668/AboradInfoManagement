package com.ustc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ustc.dao")
public class AboradinfomanagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(AboradinfomanagementApplication.class, args);
    }

}
