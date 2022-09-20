package com.clay.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.clay.mybatis.bean.Employee;

public interface EmployeeMapper {

	public List<Employee> getEmpsByConditionIf(Employee employee);

	public List<Employee> getEmpsByConditionTrim(Employee employee);

	public List<Employee> getEmpsByConditionChoose(Employee employee);

	public void updateEmp(Employee employee);

	public List<Employee> getEmpsByConditionByForeach(@Param("ids") List<Long> ids);

	public void addEmps(@Param("emps") List<Employee> emps);
	
	public void addEmps2(@Param("emps") List<Employee> emps);
	
}
