package com.clay.mybatis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;

import com.clay.mybatis.bean.Employee;

public interface EmployeeMapper {

	public boolean addEmp(Employee employee);

	public List<Employee> getAllEmp();

	public Map<String, Object> getEmpById(Long id);

	/**
	 * 使用注解告诉 MyBatis，返回的 Map 使用哪个属性作为 key
	 * 
	 * @param lastName
	 * @return
	 */
	@MapKey("id")
	public Map<String, Employee> getEmpByLastName(String lastName);

}
