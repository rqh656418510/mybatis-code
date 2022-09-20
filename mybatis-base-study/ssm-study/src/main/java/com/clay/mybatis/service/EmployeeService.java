package com.clay.mybatis.service;

import java.util.List;

import com.clay.mybatis.bean.Employee;

public interface EmployeeService {

	public List<Employee> list();

	public boolean deleteEmployee(Long id);

}
