package com.demo.elk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.demo.elk")
public class SpringbootElasticsearchDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootElasticsearchDemoApplication.class, args);
    }

}
