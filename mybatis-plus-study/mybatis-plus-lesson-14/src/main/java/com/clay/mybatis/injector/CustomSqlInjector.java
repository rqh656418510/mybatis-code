package com.clay.mybatis.injector;

import java.util.List;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.clay.mybatis.method.FindAll;

public class CustomSqlInjector extends DefaultSqlInjector {

	@Override
	public List<AbstractMethod> getMethodList(Class<?> mapperClass, TableInfo tableInfo) {
		// 获取父类中方法的集合
		List<AbstractMethod> methodList = super.getMethodList(mapperClass, tableInfo);
		// 添加自定义的通用方法
		methodList.add(new FindAll());
		return methodList;
	}

}
