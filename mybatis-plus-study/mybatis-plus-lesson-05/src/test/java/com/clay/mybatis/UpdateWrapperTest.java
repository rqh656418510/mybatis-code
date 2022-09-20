package com.clay.mybatis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.clay.mybatis.bean.Employee;
import com.clay.mybatis.dao.EmployeeMapper;

@SpringBootTest
public class UpdateWrapperTest {

	@Autowired
	private EmployeeMapper empMapper;

	/**
	 * 组装更新条件
	 */
	@Test
	public void update() {
		UpdateWrapper<Employee> wrapper = new UpdateWrapper<>();
		// 更新的条件
		wrapper.like("last_name", "a");
		wrapper.gt("age", 27);
		// 更新的字段
		wrapper.set("gender", "1");
		wrapper.set("email", null);
		Integer updateResult = empMapper.update(null, wrapper);
		System.out.println("updateResult: " + updateResult);
	}

	/**
	 * 组装更新 SQL 语句
	 */
	@Test
	public void updateSql() {
		UpdateWrapper<Employee> wrapper = new UpdateWrapper<>();
		// 更新的条件
		wrapper.like("last_name", "a");
		wrapper.gt("age", 27);
		// 更新的 SQL 语句
		wrapper.setSql("gender = '1' and email = null");
		Integer updateResult = empMapper.update(null, wrapper);
		System.out.println("updateResult: " + updateResult);
	}

}