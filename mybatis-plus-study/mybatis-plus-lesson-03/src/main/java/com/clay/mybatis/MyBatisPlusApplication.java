package com.clay.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.clay.mybatis.dao")
public class MyBatisPlusApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyBatisPlusApplication.class, args);
	}

}
