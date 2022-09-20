package com.clay.mybatis.plugin;

import java.sql.Connection;
import java.util.Properties;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;

/**
 * 插件签名：告诉 MyBatis 当前插件要拦截哪个对象的哪个方法
 */
@Intercepts({ @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class, Integer.class }) })
public class MySecondPlugin implements Interceptor {

	private Properties properties = new Properties();

	/**
	 * 拦截目标对象的目标方法的执行
	 */
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		System.out.println("MySecondPlugin ==> " + invocation.getTarget().getClass().getName() + "." + invocation.getMethod().getName() + "() 方法准备执行");
		Object result = invocation.proceed();
		System.out.println("MySecondPlugin ==> " + invocation.getTarget().getClass().getName() + "." + invocation.getMethod().getName() + "() 方法执行完成");
		return result;
	}

	/**
	 * 为目标对象创建一个代理对象
	 */
	@Override
	public Object plugin(Object target) {
		System.out.println("MySecondPlugin ==> 要包装的对象: " + target);
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