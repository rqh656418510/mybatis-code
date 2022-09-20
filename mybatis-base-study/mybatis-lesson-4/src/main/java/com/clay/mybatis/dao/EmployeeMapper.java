package com.clay.mybatis.dao;

import java.util.List;

import com.clay.mybatis.bean.Employee;

public interface EmployeeMapper {

	public Employee getEmpById(Long id);

	public boolean addEmp(Employee employee);

	public boolean updateEmp(Employee employee);

	public boolean delEmpById(Long id);

	public List<Employee> getByLastName(String lastName);

}
