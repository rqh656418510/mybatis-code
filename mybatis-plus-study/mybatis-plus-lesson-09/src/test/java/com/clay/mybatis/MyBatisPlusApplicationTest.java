package com.clay.mybatis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.clay.mybatis.bean.Employee;
import com.clay.mybatis.dao.EmployeeMapper;

@SpringBootTest
public class MyBatisPlusApplicationTest {

	@Autowired
	private EmployeeMapper empMapper;

	@Test
	public void deleteAll() {
		empMapper.delete(null);
	}

	@Test
	public void updateAll() {
		Employee employee = new Employee();
		employee.setGender("1");
		employee.setAge(26);
		empMapper.update(employee, null);
	}

}
