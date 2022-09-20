package com.clay.mybatis;

import java.util.Collections;

import org.junit.jupiter.api.Test;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

public class GeneratorCodeTest {

	/**
	 * 数据源配置
	 */
	private static final DataSourceConfig.Builder DATA_SOURCE_CONFIG = new DataSourceConfig.Builder("jdbc:mysql://127.0.0.1:3306/mybatis_plus_lesson?characterEncoding=utf8&useSSL=false", "root", "123456");

	/**
	 * 快速生成
	 */
	@Test
	public void generatorCode() {
		FastAutoGenerator.create(DATA_SOURCE_CONFIG).globalConfig(builder -> {
			builder.author("clay") // 设置作者
					.enableSwagger() // 开启Swagger2模式
					.fileOverride() // 覆盖已生成文件
					.outputDir("D://"); // 指定输出目录
		}).packageConfig(builder -> {
			builder.parent("com.clay.mybatis") // 设置父包名
					.moduleName("system") // 设置模块名
					.pathInfo(Collections.singletonMap(OutputFile.xml, "D://")); // 设置SQL映射文件的生成路径
		}).strategyConfig(builder -> {
			builder.addInclude("t_employee") // 设置需要生成的表名
					.addTablePrefix("t_"); // 设置过滤表前缀
		}).templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认使用的是Velocity引擎模板
				.execute();

	}

}
