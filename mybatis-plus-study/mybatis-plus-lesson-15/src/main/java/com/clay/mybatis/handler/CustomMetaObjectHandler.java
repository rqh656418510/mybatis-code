package com.clay.mybatis.handler;

import org.apache.ibatis.reflection.MetaObject;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;

public class CustomMetaObjectHandler implements MetaObjectHandler {

	/**
	 * 插入操作，自动填充
	 */
	@Override
	public void insertFill(MetaObject metaObject) {
		Object fieldValue = getFieldValByName("gender", metaObject);
		if (fieldValue == null) {
			System.out.println("******* 插入操作满足自动填充条件 *******");
			this.setFieldValByName("gender", "1", metaObject);
		}
	}

	/**
	 * 更新操作，自动填充
	 */
	@Override
	public void updateFill(MetaObject metaObject) {
		Object fieldValue = getFieldValByName("gender", metaObject);
		if (fieldValue == null) {
			System.out.println("******* 更新操作满足自动填充条件 *******");
			this.setFieldValByName("gender", "1", metaObject);
		}
	}

}
