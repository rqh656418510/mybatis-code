package com.clay.mybatis;

import java.util.List;

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
	public void insert() {
		Employee employee = new Employee();
		employee.setAge(16);
		employee.setGender("1");
		employee.setLastName("Oracle");
		employee.setEmail("oracle@gmail.com");
		empMapper.insert(employee);
	}

	@Test
	public void selectList() {
		List<Employee> list = empMapper.selectList(null);
		list.forEach(System.out::println);
	}

}
