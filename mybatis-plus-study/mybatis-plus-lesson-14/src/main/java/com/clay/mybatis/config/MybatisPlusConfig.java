package com.clay.mybatis.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.clay.mybatis.injector.CustomSqlInjector;

@Configuration
@MapperScan("com.clay.mybatis.dao")
public class MybatisPlusConfig {

	@Bean
	public CustomSqlInjector customSqlInjector() {
		return new CustomSqlInjector();
	}

}
