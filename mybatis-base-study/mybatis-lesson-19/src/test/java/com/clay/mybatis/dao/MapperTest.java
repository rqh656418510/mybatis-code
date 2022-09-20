package com.clay.mybatis.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.clay.mybatis.bean.Department;
import com.clay.mybatis.bean.Employee;

public class MapperTest {

	public static void main(String[] args) throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		SqlSession session = sqlSessionFactory.openSession();
		try {
			EmployeeMapper empMapper = session.getMapper(EmployeeMapper.class);
			List<Employee> employees = empMapper.selectAll();
			System.out.println(employees);

			DepartmentMapper deptMapper = session.getMapper(DepartmentMapper.class);
			Department dept = deptMapper.selectByPrimaryKey(1);
			System.out.println(dept);

			// 手动提交事务
			session.commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

}
