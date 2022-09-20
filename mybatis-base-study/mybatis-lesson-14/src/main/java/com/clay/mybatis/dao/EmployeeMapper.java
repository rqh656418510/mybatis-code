package com.clay.mybatis.dao;

import org.apache.ibatis.annotations.Param;

import com.clay.mybatis.bean.Employee;

public interface EmployeeMapper {

	public boolean addEmp(@Param("employee") Employee employee);

	public Employee getEmpAndDept(Long id);
	
}
