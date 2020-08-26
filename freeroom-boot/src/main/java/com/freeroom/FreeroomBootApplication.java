package com.freeroom;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.freeroom.mapper")
@SpringBootApplication
public class FreeroomBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(FreeroomBootApplication.class, args);
    }

}
