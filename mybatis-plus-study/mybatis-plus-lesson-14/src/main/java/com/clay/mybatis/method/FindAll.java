package com.clay.mybatis.method;

import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.metadata.TableInfo;

public class FindAll extends AbstractMethod {

	@Override
	public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
		// 执行的 SQL 语句
		String sql = "select * from " + tableInfo.getTableName();

		// 方法名称，必须与 Mapper 接口中的方法名一致
		String method = "findAll";

		// 添加 MappedStatement（作用相当于编写 SQL 映射文件）
		SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, modelClass);
		MappedStatement mappedStatement = this.addSelectMappedStatementForOther(mapperClass, method, sqlSource, modelClass);
		return mappedStatement;
	}

}
