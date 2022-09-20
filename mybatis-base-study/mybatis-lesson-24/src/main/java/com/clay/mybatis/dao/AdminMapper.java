package com.clay.mybatis.dao;

import com.clay.mybatis.bean.Admin;

public interface AdminMapper {

	public Admin getAdminById(Long id);

	public boolean addAdmin(Admin admin);

}
