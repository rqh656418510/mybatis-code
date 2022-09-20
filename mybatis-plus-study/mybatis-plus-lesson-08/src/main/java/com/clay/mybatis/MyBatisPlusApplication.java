package com.clay.mybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.clay.mybatis")
public class MyBatisPlusApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyBatisPlusApplication.class, args);
	}

}
