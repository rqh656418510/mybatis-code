package com.clay.mybatis.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.clay.mybatis.bean.Employee;

public interface IEmployeeService extends IService<Employee> {

	public Page<Employee> queryByPage();

}
