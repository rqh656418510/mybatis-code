package com.clay.mybatis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.clay.mybatis.bean.Employee;
import com.clay.mybatis.dao.EmployeeMapper;

@SpringBootTest
public class MyBatisPlusApplicationTest {

	@Autowired
	private EmployeeMapper employeeMapper;

	@Test
	public void insert() {
		Employee employee = new Employee();
		employee.setEmail("clion@gmail.com");
		employee.setLastName("Clion");
		employee.setAge(26);
		employeeMapper.insert(employee);
	}

	@Test
	public void update() {
		Employee employee = new Employee();
		employee.setId(1L);
		employee.setEmail("empty@gmai.com");
		employeeMapper.updateById(employee);
	}

}
