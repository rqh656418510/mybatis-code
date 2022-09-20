package com.clay.mybatis.bean;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;

public class Employee extends Model<Employee> {

	private Long id;

	private String lastName;

	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String gender;

	private String email;

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

	@Override
	public Serializable pkVal() {
		return this.id;
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
