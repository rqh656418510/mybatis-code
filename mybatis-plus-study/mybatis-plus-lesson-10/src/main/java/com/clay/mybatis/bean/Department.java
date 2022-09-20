package com.clay.mybatis.bean;

import com.baomidou.mybatisplus.annotation.TableLogic;

public class Department {

	private Long id;

	private String name;

	@TableLogic
	private Integer deleted;

	public Department() {

	}

	public Department(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
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

	public Integer getDeleted() {
		return deleted;
	}

	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", deleted=" + deleted + "]";
	}

}
