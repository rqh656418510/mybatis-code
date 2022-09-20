package com.clay.mybatis.plugin;

import java.sql.Connection;
import java.util.Properties;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

/**
 * 插件签名：告诉 MyBatis 当前插件要拦截哪个对象的哪个方法
 */
@Intercepts({ @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class, Integer.class }) })
public class MyThirdPlugin implements Interceptor {

	private Properties properties = new Properties();

	/**
	 * 拦截目标对象的目标方法的执行
	 */
	@Override
	public Object intercept(Invocation invocation) throws Throwable {

		// 获取目标对象
		Object target = invocation.getTarget();

		// 分离被代理对象的元数据
		MetaObject metaObject = SystemMetaObject.forObject(target);

		// 更改 SQL 语句要用的参数
		metaObject.setValue("parameterHandler.parameterObject", 11L);

		// 执行目标方法
		Object proceed = invocation.proceed();

		// 返回执行结果
		return proceed;
	}

	/**
	 * 为目标对象创建一个代理对象
	 */
	@Override
	public Object plugin(Object target) {
		Object wrap = Plugin.wrap(target, this);
		return wrap;
	}

	/**
	 * 将插件注册时的Property属性设置进来
	 */
	@Override
	public void setProperties(Properties properties) {
		this.properties = properties;
	}

}