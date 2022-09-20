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
		// 查询条件是表字段的名称，而不是实体类的属性名
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

	/**
	 * 插入数据
	 */
	@Test
	public void insert() {
		Employee employee = new Employee();
		employee.setLastName("David");
		employee.setEmail("david@gmail.com");
		Integer insertResult = empMapper.insert(employee);
		System.out.println("insertResult: " + insertResult);
		System.out.println(employee);
	}

	/**
	 * 更新数据
	 */
	@Test
	public void update() {
		Employee employee = new Employee();
		employee.setId(1L);
		employee.setLastName("David");
		employee.setEmail("david@gmail.com");
		Integer updateReuslt = empMapper.updateById(employee);
		System.out.println("updateReuslt: " + updateReuslt);
	}

	/**
	 * 根据ID删除数据
	 */
	@Test
	public void deleteById() {
		Integer deleteResult = empMapper.deleteById(2L);
		System.out.println("deleteResult: " + deleteResult);
	}

	/**
	 * 根据多个ID删除数据
	 */
	@Test
	public void deleteBatchIds() {
		List<Long> ids = Arrays.asList(2L, 3L);
		Integer deleteResult = empMapper.deleteBatchIds(ids);
		System.out.println("deleteResult: " + deleteResult);
	}

	/**
	 * 根据Map条件删除数据
	 */
	@Test
	public void deleteByMap() {
		Map<String, Object> columnMap = new HashMap<String, Object>();
		// 查询条件是表字段的名称，而不是实体类的属性名
		columnMap.put("gender", "0");
		Integer deleteResult = empMapper.deleteByMap(columnMap);
		System.out.println("deleteResult: " + deleteResult);
	}

}
