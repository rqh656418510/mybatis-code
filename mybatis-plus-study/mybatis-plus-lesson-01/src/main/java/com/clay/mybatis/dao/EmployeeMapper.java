package com.clay.mybatis.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.clay.mybatis.bean.Employee;

public interface EmployeeMapper extends BaseMapper<Employee> {

	public Employee getById(Long id);

}
