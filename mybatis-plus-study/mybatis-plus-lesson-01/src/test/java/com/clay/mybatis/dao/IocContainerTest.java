package com.clay.mybatis.dao;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;

import com.clay.mybatis.bean.Employee;

public class IocContainerTest {

	private static final ClassPathXmlApplicationContext iocContext = new ClassPathXmlApplicationContext("application.xml");

	private static final EmployeeMapper empMapper = iocContext.getBean("employeeMapper", EmployeeMapper.class);

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
