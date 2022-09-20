package com.clay.mybatis;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.clay.mybatis.bean.Employee;
import com.clay.mybatis.service.IEmployeeService;

@SpringBootTest
public class MyBatisPlusApplicationTest {

	@Autowired
	private IEmployeeService empService;

	/**
	 * 查询总记录数
	 */
	@Test
	public void count() {
		Long count = empService.count();
		System.out.println("count: " + count);
	}

	/**
	 * 更新数据
	 */
	@Test
	public void update() {
		Employee employee = new Employee();
		employee.setId(1L);
		employee.setGender("0");
		boolean updateResult = empService.updateById(employee);
		System.out.println("updateResult: " + updateResult);
	}

	/**
	 * 批量插入
	 */
	@Test
	public void saveBatch() {
		List<Employee> list = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			Employee emp = new Employee();
			emp.setAge(26);
			emp.setGender("1");
			emp.setLastName("user-" + i);
			list.add(emp);
		}
		boolean saveResult = this.empService.saveBatch(list);
		System.out.println("saveResult: " + saveResult);
	}

	/**
	 * 删除数据
	 */
	@Test
	public void delete() {
		boolean deleteResult = this.empService.removeById(11L);
		System.out.println("deleteResult: " + deleteResult);
	}

}
