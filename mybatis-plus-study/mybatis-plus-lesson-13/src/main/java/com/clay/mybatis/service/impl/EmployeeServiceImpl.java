package com.clay.mybatis.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.clay.mybatis.bean.Employee;
import com.clay.mybatis.dao.EmployeeMapper;
import com.clay.mybatis.service.IEmployeeService;

@Service
@DS("mysql_1")
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {

	@Override
	public Page<Employee> queryByPage() {
		Page<Employee> page = new Page<>(1, 10);
		QueryWrapper<Employee> wrapper = new QueryWrapper<>();
		wrapper.like("last_name", "i");
		baseMapper.selectPage(page, wrapper);
		return page;
	}

}
