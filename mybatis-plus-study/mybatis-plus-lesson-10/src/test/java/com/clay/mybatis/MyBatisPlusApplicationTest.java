package com.clay.mybatis;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.clay.mybatis.bean.Department;
import com.clay.mybatis.dao.DepartmentMapper;

@SpringBootTest
public class MyBatisPlusApplicationTest {

	@Autowired
	private DepartmentMapper deptMapper;
	
	@Test
	public void select() {
		List<Department> list = deptMapper.selectList(null);
		list.forEach(System.out::println);
	}

	@Test
	public void selectByWrapper() {
		QueryWrapper<Department> wrapper = new QueryWrapper<>();
		wrapper.like("name", "测试");
		List<Department> list = deptMapper.selectList(wrapper);
		list.forEach(System.out::println);
	}

	@Test
	public void delete() {
		int deleteResult = deptMapper.deleteById(1L);
		System.out.println("deleteResult: " + (deleteResult > 0));
	}

	@Test
	public void update() {
		Department department = new Department();
		department.setName("行政部");
		department.setId(1L);
		int updateResult = deptMapper.updateById(department);
		System.out.println("updateResult: " + (updateResult > 0));
	}

}
