package com.clay.mybatis.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.baomidou.mybatisplus.core.incrementer.IKeyGenerator;
import com.baomidou.mybatisplus.extension.incrementer.OracleKeyGenerator;

@Configuration
@MapperScan("com.clay.mybatis.dao")
public class MybatisPlusConfig {

	@Bean
	public IKeyGenerator keyGenerator() {
		return new OracleKeyGenerator();
	}

}
