package com.clay.mybatis.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.clay.mybatis.handler.CustomMetaObjectHandler;

@Configuration
@MapperScan("com.clay.mybatis.dao")
public class MybatisPlusConfig {

	@Bean
	public CustomMetaObjectHandler customMetaObjectHandler() {
		return new CustomMetaObjectHandler();
	}

}
