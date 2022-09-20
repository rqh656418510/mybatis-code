package com.clay.mybatis;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.clay.mybatis.bean.Department;
import com.clay.mybatis.bean.Employee;
import com.clay.mybatis.service.IDepartmentService;
import com.clay.mybatis.service.IEmployeeService;

@SpringBootTest
public class MyBatisPlusApplicationTest {

	@Autowired
	private IEmployeeService empService;

	@Autowired
	private IDepartmentService deptService;

	@Test
	public void dynamicDataSource() {
		Page<Employee> empPage = empService.queryByPage();
		List<Employee> empList = empPage.getRecords();
		empList.forEach(System.out::println);

		Page<Department> deptPage = deptService.queryByPage();
		List<Department> deptList = deptPage.getRecords();
		deptList.forEach(System.out::println);
	}

}
