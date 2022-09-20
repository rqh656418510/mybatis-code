package com.clay.mybatis;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.clay.mybatis.bean.Employee;
import com.clay.mybatis.dao.EmployeeMapper;

@SpringBootTest
public class PagePluginTest {

	@Autowired
	private EmployeeMapper empMapper;

	/**
	 * 基于通用 Mapper 的分页查询
	 */
	@Test
	public void selectByPage() {
		// 分页信息
		Page<Employee> page = new Page<>(2, 2);

		// 查询条件
		QueryWrapper<Employee> wrapper = new QueryWrapper<>();
		wrapper.eq("gender", "1");

		// 执行分页查询
		empMapper.selectPage(page, wrapper);

		// 获取分页结果
		List<Employee> list = page.getRecords();
		list.forEach(System.out::println);

		// 获取分页信息
		System.out.println("总页数： " + page.getPages());
		System.out.println("总记录数： " + page.getTotal());
		System.out.println("当前的页码： " + page.getCurrent());
		System.out.println("每页的记录数： " + page.getSize());
		System.out.println("是否有上一页： " + page.hasPrevious());
		System.out.println("是否有下一页： " + page.hasNext());
	}

	/**
	 * 基于 ActiveRecord 模式的分页查询
	 */
	@Test
	public void selectByPageForAR() {
		// 分页信息
		Page<Employee> page = new Page<>(2, 2);

		// 查询条件
		QueryWrapper<Employee> wrapper = new QueryWrapper<>();
		wrapper.eq("gender", "1");

		// 执行分页查询
		Employee employee = new Employee();
		employee.selectPage(page, wrapper);

		// 获取分页结果
		List<Employee> list = page.getRecords();
		list.forEach(System.out::println);

		// 获取分页信息
		System.out.println("总页数： " + page.getPages());
		System.out.println("总记录数： " + page.getTotal());
		System.out.println("当前的页码： " + page.getCurrent());
		System.out.println("每页的记录数： " + page.getSize());
		System.out.println("是否有上一页： " + page.hasPrevious());
		System.out.println("是否有下一页： " + page.hasNext());
	}

	/**
	 * 基于自定义 Mapper 方法（返回值为 IPage）的分页查询
	 */
	@Test
	public void queryByPage() {
		// 分页信息
		Page<Employee> page = new Page<>(2, 2);

		// 执行分页查询
		empMapper.queryByPage(page, "1");

		// 获取分页结果
		List<Employee> list = page.getRecords();
		list.forEach(System.out::println);

		// 获取分页信息
		System.out.println("总页数： " + page.getPages());
		System.out.println("总记录数： " + page.getTotal());
		System.out.println("当前的页码： " + page.getCurrent());
		System.out.println("每页的记录数： " + page.getSize());
		System.out.println("是否有上一页： " + page.hasPrevious());
		System.out.println("是否有下一页： " + page.hasNext());
	}

	/**
	 * 基于自定义 Mapper 方法（返回值为 List）的分页查询
	 */
	@Test
	public void queryListByPage() {
		// 分页信息
		Page<Employee> page = new Page<>(2, 2);

		// 执行分页查询
		List<Employee> list = empMapper.queryListByPage(page, "1");
		list.forEach(System.out::println);

		// 获取分页信息
		System.out.println("总页数： " + page.getPages());
		System.out.println("总记录数： " + page.getTotal());
		System.out.println("当前的页码： " + page.getCurrent());
		System.out.println("每页的记录数： " + page.getSize());
		System.out.println("是否有上一页： " + page.hasPrevious());
		System.out.println("是否有下一页： " + page.hasNext());
	}

}
