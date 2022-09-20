package com.clay.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.clay.mybatis.bean.Employee;

@Mapper
public interface EmployeeMapper {

	public List<Employee> queryAll();

	public boolean delEmpById(Long id);

}