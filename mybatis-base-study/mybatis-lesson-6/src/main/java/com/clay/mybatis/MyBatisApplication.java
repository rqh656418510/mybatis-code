package com.clay.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.clay.mybatis.bean.Employee;
import com.clay.mybatis.dao.EmployeeMapper;

/**
 * 1、创建MyBatis的全局配置文件，包含数据源的一些运行环境信息
 * 
 * 2、创建SQL映射文件，配置每一个SQL，以及SQL的封装规则等
 * 
 * 3、将SQL映射文件注册到MyBatis的全局配置文件中
 * 
 * 4、写代码： 1）、根据全局配置文件得到SqlSessionFactory
 * 2）、使用SqlSessionFactory获取到SqlSession对象，使用它来执行增删改查操作，一个SqlSession就是代表和数据库的一次会话，用完需要关闭
 * 3）、使用SQL的唯一标志来告诉MyBatis执行哪个SQL，对应的SQL都是保存在SQL映射文件中
 */
public class MyBatisApplication {

	public static void main(String[] args) throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		SqlSession session = sqlSessionFactory.openSession();
		try {
			// MyBatis会自动创建一个代理对象，由代理对象去执行增删改查方法
			EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);

			// 插入数据
			Employee newEmployee = new Employee("Tom", "1", "tom@gmail.com");
			mapper.addEmp(newEmployee);

			// 单参数处理
			Employee employee = mapper.getEmpById(newEmployee.getId());
			System.out.println(employee);

			// 单参数处理（集合类型）
			List<Long> ids = Arrays.asList(newEmployee.getId(), 2L);
			List<Employee> employeeList = mapper.getEmpByIds(ids);
			System.out.println(employeeList);

			// 多参数处理
			Employee employee2 = mapper.getEmpByIdAndEmail(newEmployee.getId(), newEmployee.getEmail());
			System.out.println(employee2);

			// 多参数处理（使用Map）
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("id", newEmployee.getId());
			params.put("email", newEmployee.getEmail());
			Employee employee3 = mapper.getEmpByIdAndEmailByMap(params);
			System.out.println(employee3);

			// 多参数处理（使用注解）
			Employee employee4 = mapper.getEmpByIdAndEmailByAnnotation(newEmployee.getId(), newEmployee.getEmail());
			System.out.println(employee4);

			// MyBatis 内置参数
			Employee employee5 = new Employee();
			employee5.setEmail("tom@gmail.com");
			List<Employee> employeList2 = mapper.getEmpByInnerParameter(employee5);
			System.out.println(employeList2);

			// 手动提交事务
			session.commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

}
