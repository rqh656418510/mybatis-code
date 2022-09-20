package com.clay.mybatis.bean;

import com.clay.mybatis.enums.AdminType;

public class Admin {

	private Long id;

	private String name;

	private AdminType type;

	public Admin() {

	}

	public Admin(String name, AdminType type) {
		super();
		this.name = name;
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AdminType getType() {
		return type;
	}

	public void setType(AdminType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", name=" + name + ", type=" + type + "]";
	}

}
