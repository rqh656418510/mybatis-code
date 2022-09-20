package com.clay.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.clay.mybatis.bean.Employee;

public interface EmployeeMapper extends BaseMapper<Employee> {

	/**
	 * 第一种方式：方法的返回值为 IPage 类型
	 * 
	 * @param page
	 * @param gender
	 * @return
	 */
	IPage<Employee> queryByPage(IPage<Employee> page, @Param("gender") String gender);

	/**
	 * 第二种方式：方法的返回值为 List 类型
	 * 
	 * @param page
	 * @param gender
	 * @return
	 */
	List<Employee> queryListByPage(IPage<Employee> page, @Param("gender") String gender);

}
