package com.clay.mybatis.enums;

/**
 * 枚举实现类
 */
public enum AdminStatus implements BaseEnum<AdminStatus, Integer> {

	VALID(1, "有效"), INVALID(0, "无效");

	private final Integer value;

	private final String description;

	@Override
	public Integer getValue() {
		return this.value;
	}

	@Override
	public String getDescription() {
		return this.description;
	}

	private AdminStatus(Integer value, String description) {
		this.value = value;
		this.description = description;
	}

}