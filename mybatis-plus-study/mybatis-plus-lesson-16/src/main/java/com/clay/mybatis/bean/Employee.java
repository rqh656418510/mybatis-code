package com.clay.mybatis.bean;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;

@KeySequence(value = "seq_employee", dbType = DbType.ORACLE)
public class Employee {

	@TableId(type = IdType.INPUT)
	private Long id;

	private String email;

	private String lastName;

	private String gender;

	private Integer age;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Employee() {

	}

	public Employee(String lastName, String gender, String email, Integer age) {
		super();
		this.lastName = lastName;
		this.gender = gender;
		this.email = email;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", lastName=" + lastName + ", gender=" + gender + ", email=" + email + ", age=" + age + "]";
	}

}
