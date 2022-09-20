package com.clay.mybatis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.clay.mybatis.bean.Employee;
import com.clay.mybatis.dao.EmployeeMapper;

@SpringBootTest
public class LambdaUpdateWrapperTest {

	@Autowired
	private EmployeeMapper empMapper;

	/**
	 * 组装更新条件
	 */
	@Test
	public void update() {
		LambdaUpdateWrapper<Employee> wrapper = new LambdaUpdateWrapper<>();
		wrapper.like(Employee::getLastName, "a")
				 .gt(Employee::getAge, 27)
				 .set(Employee::getGender, "1")
				 .set(Employee::getEmail, null);
		Integer updateResult = empMapper.update(null, wrapper);
		System.out.println("updateResult: " + updateResult);
	}

	/**
	 * 组装更新 SQL 语句
	 */
	@Test
	public void updateSql() {
		LambdaUpdateWrapper<Employee> wrapper = new LambdaUpdateWrapper<>();
		wrapper.like(Employee::getLastName, "a")
				 .gt(Employee::getAge, 27)
				 .setSql("gender = '1' and email = null");
		Integer updateResult = empMapper.update(null, wrapper);
		System.out.println("updateResult: " + updateResult);
	}
	
}
