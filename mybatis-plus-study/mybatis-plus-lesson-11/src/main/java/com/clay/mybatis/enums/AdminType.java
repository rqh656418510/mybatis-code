package com.clay.mybatis.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

public enum AdminType {

	ROOT(0, "Root"), ADMIN(1, "Admin");

	@EnumValue
	private Integer value;

	private String description;

	public Integer getValue() {
		return this.value;
	}

	public String getDescription() {
		return this.description;
	}

	private AdminType(Integer value, String description) {
		this.value = value;
		this.description = description;
	}

}
