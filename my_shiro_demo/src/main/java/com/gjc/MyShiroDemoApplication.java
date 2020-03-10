package com.gjc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.gjc.dao")
public class MyShiroDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyShiroDemoApplication.class, args);
    }

}
