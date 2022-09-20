package com.clay.mybatis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clay.mybatis.bean.Employee;
import com.clay.mybatis.dao.EmployeeMapper;
import com.clay.mybatis.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeMapper employeeMapper;

	@Override
	public List<Employee> list() {
		return this.employeeMapper.queryAll();
	}

	@Override
	public boolean deleteEmployee(Long id) {
		return this.employeeMapper.delEmpById(id);
	}

}
