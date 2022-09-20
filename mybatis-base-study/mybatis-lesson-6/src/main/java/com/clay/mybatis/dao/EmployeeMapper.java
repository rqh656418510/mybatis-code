package com.clay.mybatis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.clay.mybatis.bean.Employee;

public interface EmployeeMapper {

	public boolean addEmp(Employee employee);

	public Employee getEmpById(Long id);

	public List<Employee> getEmpByIds(List<Long> ids);

	public Employee getEmpByIdAndEmail(Long id, String email);

	public Employee getEmpByIdAndEmailByMap(Map<String, Object> params);

	public Employee getEmpByIdAndEmailByAnnotation(@Param("id") Long id, @Param("email") String email);

	public List<Employee> getEmpByInnerParameter(Employee employee);

}
