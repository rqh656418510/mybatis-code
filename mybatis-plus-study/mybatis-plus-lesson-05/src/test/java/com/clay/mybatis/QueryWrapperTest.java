package com.clay.mybatis;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.clay.mybatis.bean.Employee;
import com.clay.mybatis.dao.EmployeeMapper;

@SpringBootTest
public class QueryWrapperTest {

	@Autowired
	private EmployeeMapper empMapper;

	/**
	 * 组装查询条件
	 */
	@Test
	public void selectList() {
		QueryWrapper<Employee> wrapper = new QueryWrapper<>();
		wrapper.like("last_name", 'i');
		wrapper.isNotNull("email");
		wrapper.between("age", 20, 25);
		List<Employee> list = empMapper.selectList(wrapper);
		list.forEach(System.out::println);
	}

	/**
	 * 组装排序条件
	 */
	@Test
	public void orderBy() {
		QueryWrapper<Employee> wrapper = new QueryWrapper<>();
		wrapper.orderByDesc("age");
		wrapper.orderByAsc("last_name");
		List<Employee> list = empMapper.selectList(wrapper);
		list.forEach(System.out::println);
	}

	/**
	 * 组装删除条件
	 */
	@Test
	public void delete() {
		QueryWrapper<Employee> wrapper = new QueryWrapper<>();
		wrapper.isNull("email");
		Integer deleteResult = empMapper.delete(wrapper);
		System.out.println("deleteResult: " + deleteResult);
	}

	/**
	 * 组装更新条件
	 */
	@Test
	public void update() {
		QueryWrapper<Employee> wrapper = new QueryWrapper<>();
		wrapper.ge("age", 26);
		Employee employee = new Employee();
		employee.setLastName("Jim");
		Integer updateResult = empMapper.update(employee, wrapper);
		System.out.println("updateResult: " + updateResult);
	}

	/**
	 * 条件的优先级
	 */
	@Test
	public void conditionOrder() {
		QueryWrapper<Employee> wrapper = new QueryWrapper<>();
		// Lambda 表达式中的条件优先执行，这里更改姓名中包含a并且（年龄大于26或邮箱为Null）的员工信息
		wrapper.like("last_name", "a").and(i -> i.gt("age", 26).or().isNull("email"));
		Employee employee = new Employee();
		employee.setLastName("Albert");
		Integer updateResult = empMapper.update(employee, wrapper);
		System.out.println("updateResult: " + updateResult);
	}

	/**
	 * 组装 Select 语句
	 */
	@Test
	public void selectColumns() {
		// 查询指定的列
		QueryWrapper<Employee> wrapper = new QueryWrapper<>();
		wrapper.select("last_name", "gender");
		List<Map<String, Object>> list = empMapper.selectMaps(wrapper);
		list.forEach(System.out::println);
	}

	/**
	 * 组装嵌套子查询
	 */
	@Test
	public void nestedSubSelect() {
		QueryWrapper<Employee> wrapper = new QueryWrapper<>();
		wrapper.inSql("id", "select id from t_employee where age <= 28");
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
		QueryWrapper<Employee> wrapper = new QueryWrapper<>();
		// 当 Condition 条件成立时，才会拼接 SQL 语句
		wrapper.like(StringUtils.isNotBlank(lastName), "last_name", lastName);
		wrapper.ge(minAge != null, "age", minAge);
		wrapper.le(maxAge != null, "age", maxAge);
		List<Employee> list = empMapper.selectList(wrapper);
		list.forEach(System.out::println);
	}

}