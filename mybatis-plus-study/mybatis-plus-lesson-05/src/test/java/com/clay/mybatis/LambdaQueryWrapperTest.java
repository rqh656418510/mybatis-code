package com.clay.mybatis;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.clay.mybatis.bean.Employee;
import com.clay.mybatis.dao.EmployeeMapper;

@SpringBootTest
public class LambdaQueryWrapperTest {

	@Autowired
	private EmployeeMapper empMapper;

	/**
	 * 组装查询条件
	 */
	@Test
	public void selectList() {
		LambdaQueryWrapper<Employee> wrapper = new LambdaQueryWrapper<>();
		wrapper.like(Employee::getLastName, 'j').le(Employee::getAge, 28).eq(Employee::getGender, "1");
		List<Employee> list = empMapper.selectList(wrapper);
		list.forEach(System.out::println);
	}

	/**
	 * 条件的优先级
	 */
	@Test
	public void conditionOrder() {
		LambdaQueryWrapper<Employee> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(Employee::getLastName, "jim");
		wrapper.and(i -> i.gt(Employee::getAge, 26).or().isNull(Employee::getEmail));
		List<Employee> list = empMapper.selectList(wrapper);
		list.forEach(System.out::println);
	}

	/**
	 * Condition 组装条件
	 */
	@Test
	public void condition() {
		Integer minAge = 25;
		Integer maxAge = null;
		String lastName = "j";
		LambdaQueryWrapper<Employee> wrapper = new LambdaQueryWrapper<>();
		// 当 Condition 条件成立时，才会拼接 SQL 语句
		wrapper.like(StringUtils.isNotBlank(lastName), Employee::getLastName, lastName).ge(minAge != null, Employee::getAge, minAge).le(maxAge != null, Employee::getAge, maxAge);
		List<Employee> list = empMapper.selectList(wrapper);
		list.forEach(System.out::println);
	}

}
