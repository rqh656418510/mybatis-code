package com.clay.mybatis.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.clay.mybatis.bean.Department;

public interface IDepartmentService extends IService<Department> {

	public Page<Department> queryByPage();

}
