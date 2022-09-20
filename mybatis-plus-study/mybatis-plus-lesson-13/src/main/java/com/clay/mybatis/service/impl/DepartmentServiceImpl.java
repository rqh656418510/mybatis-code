package com.clay.mybatis.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.clay.mybatis.bean.Department;
import com.clay.mybatis.dao.DepartmentMapper;
import com.clay.mybatis.service.IDepartmentService;

@Service
@DS("mysql_2")
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements IDepartmentService {

	@Override
	public Page<Department> queryByPage() {
		Page<Department> page = new Page<>(1, 10);
		QueryWrapper<Department> wrapper = new QueryWrapper<>();
		wrapper.like("name", "开发");
		baseMapper.selectPage(page, wrapper);
		return page;
	}

}
