package com.clay.mybatis;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.clay.mybatis.bean.Employee;
import com.clay.mybatis.dao.EmployeeMapper;

@SpringBootTest
public class MyBatisPlusApplicationTest {

	@Autowired
	private EmployeeMapper empMapper;

	/**
	 * 根据ID查询
	 */
	@Test
	public void selectById() {
		Employee employee = empMapper.selectById(1L);
		System.out.println(employee);
	}

	/**
	 * 根据多个ID查询
	 */
	@Test
	public void selectBatchIds() {
		List<Long> ids = Arrays.asList(1L, 2L, 3L);
		List<Employee> list = empMapper.selectBatchIds(ids);
		list.forEach(System.out::println);
	}

	/**
	 * 根据Map条件查询
	 */
	@Test
	public void selectByMap() {
		Map<String, Object> columnMap = new HashMap<String, Object>();
		columnMap.put("last_name", "Jim");
		List<Employee> list = empMapper.selectByMap(columnMap);
		list.forEach(System.out::println);
	}

	/**
	 * 查询所有数据
	 */
	@Test
	public void selectList() {
		List<Employee> list = empMapper.selectList(null);
		list.forEach(System.out::println);
	}

}
