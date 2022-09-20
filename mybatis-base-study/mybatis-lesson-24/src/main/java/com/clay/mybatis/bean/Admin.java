package com.clay.mybatis.bean;

import com.clay.mybatis.enums.AdminStatus;

public class Admin {

	private Long id;
	private String name;
	private String email;
	private AdminStatus status;

	public Admin() {

	}

	public Admin(String name, String email, AdminStatus status) {
		super();
		this.name = name;
		this.email = email;
		this.status = status;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public AdminStatus getStatus() {
		return status;
	}

	public void setStatus(AdminStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", name=" + name + ", email=" + email + ", status=" + status + "]";
	}

}
