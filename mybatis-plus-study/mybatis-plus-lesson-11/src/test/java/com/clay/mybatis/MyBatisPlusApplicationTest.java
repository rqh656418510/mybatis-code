package com.clay.mybatis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.clay.mybatis.bean.Admin;
import com.clay.mybatis.dao.AdminMapper;
import com.clay.mybatis.enums.AdminType;

@SpringBootTest
public class MyBatisPlusApplicationTest {

	@Autowired
	private AdminMapper adminMapper;

	@Test
	public void insert() {
		Admin admin = new Admin();
		admin.setName("David");
		admin.setType(AdminType.ROOT);
		adminMapper.insert(admin);
		System.out.println(admin);
	}

	@Test
	public void select() {
		Admin admin = adminMapper.selectById(1L);
		System.out.println(admin);
	}

}
