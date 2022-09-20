package com.clay.mybatis.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import com.clay.mybatis.bean.Employee;

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:application.xml")
public class MyBatisPlusTest {

	@Autowired
	private EmployeeMapper empMapper;

	@Test
	public void select() {
		Employee employee = empMapper.selectById(1L);
		Assert.notNull(employee, "entity not be null");
		System.out.println(employee);
	}

	@Test
	public void insert() {
		Employee employee = new Employee("David", "1", "david@gmail.com", 23);
		Integer insertResult = empMapper.insert(employee);
		Assert.isTrue(insertResult > 0, "");
		System.out.println("insert result: " + insertResult);
	}

	@Test
	public void getById() {
		Employee employee = empMapper.getById(1L);
		Assert.notNull(employee, "entity not be null");
		System.out.println(employee);
	}

}
