package com.clay.mybatis.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.clay.mybatis.bean.Employee;
import com.clay.mybatis.dao.EmployeeMapper;
import com.clay.mybatis.service.IEmployeeService;

/**
 * EmployeeServiceImpl 类实现了 IEmployeeService 接口，并继承 ServiceImpl 类提供的基础功能
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {

}
