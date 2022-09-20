package com.clay.mybatis;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.clay.mybatis.bean.Employee;

@SpringBootTest
public class ActiveRecordTest {

	/**
	 * 根据ID查询数据
	 */
	@Test
	public void selectById() {
		Employee employee = new Employee();
		employee.setId(1L);
		Employee result = employee.selectById();
		System.out.println(result);
	}

	/**
	 * 查询所有数据
	 */
	@Test
	public void selectAll() {
		Employee employee = new Employee();
		List<Employee> list = employee.selectAll();
		list.forEach(System.out::println);
	}

	/**
	 * 根据条件查询数据
	 */
	@Test
	public void selectByWrapper() {
		QueryWrapper<Employee> wrapper = new QueryWrapper<>();
		wrapper.like("last_name", "j");
		wrapper.eq("gender", "1");

		Employee employee = new Employee();
		List<Employee> list = employee.selectList(wrapper);
		list.forEach(System.out::println);
	}

	/**
	 * 查询总记录数
	 */
	@Test
	public void selectCount() {
		Employee employee = new Employee();
		Long count = employee.selectCount(null);
		System.out.println("count: " + count);
	}

	/**
	 * 插入数据
	 */
	@Test
	public void insert() {
		Employee employee = new Employee();
		employee.setAge(24);
		employee.setGender("1");
		employee.setLastName("David");
		employee.setEmail("david@gmail.com");
		boolean insertResult = employee.insert();
		System.out.println("insertResult: " + insertResult);
	}

	/**
	 * 根据ID更改数据
	 */
	@Test
	public void updateById() {
		Employee employee = new Employee();
		employee.setId(1L);
		employee.setAge(24);
		employee.setGender("1");
		boolean updateResult = employee.updateById();
		System.out.println("updateResult: " + updateResult);
	}

	/**
	 * 根据条件更改数据
	 */
	@Test
	public void updateByWrapper() {
		QueryWrapper<Employee> wraper = new QueryWrapper<>();
		wraper.isNull("email");
		wraper.eq("gender", "1");

		Employee employee = new Employee();
		employee.setAge(24);
		boolean updateResult = employee.update(wraper);
		System.out.println("updateResult: " + updateResult);
	}

	/**
	 * 根据ID删除数据
	 */
	@Test
	public void deleteById() {
		Employee employee = new Employee();
		employee.setId(11L);
		boolean deleteResult = employee.deleteById();
		System.out.println("deleteResult: " + deleteResult);
	}

	/**
	 * 根据条件删除数据
	 */
	@Test
	public void deleteByWrapper() {
		QueryWrapper<Employee> wraper = new QueryWrapper<>();
		wraper.isNull("email");
		wraper.eq("gender", "1");

		Employee employee = new Employee();
		boolean deleteResult = employee.delete(wraper);
		System.out.println("deleteResult: " + deleteResult);
	}

}