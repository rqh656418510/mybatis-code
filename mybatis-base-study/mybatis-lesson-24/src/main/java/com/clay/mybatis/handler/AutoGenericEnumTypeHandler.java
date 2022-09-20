package com.clay.mybatis.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import com.clay.mybatis.enums.BaseEnum;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

/**
 * MyBatis 枚举类型处理类
 */
public class AutoGenericEnumTypeHandler<E extends BaseEnum<?, ?>> extends BaseTypeHandler<E> {

	private Class<E> enumType;
	private E[] enums;

	public AutoGenericEnumTypeHandler() {

	}

	public AutoGenericEnumTypeHandler(Class<E> type) {
		if (Objects.isNull(type)) {
			throw new IllegalArgumentException("Type argument cannot be null");
		}
		this.enumType = type;
		this.enums = type.getEnumConstants();
		if (Objects.isNull(this.enums)) {
			throw new IllegalArgumentException(type.getName() + " does not represent an enum type");
		}
	}

	private E loadEnum(Object index) {
		for (E e : enums) {
			if (e.getValue().toString().equals(index.toString())) {
				return e;
			}
		}
		throw new IllegalArgumentException(enumType.getName() + " unknown enumerated type index : " + index);
	}

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, E parameter, JdbcType jdbcType) throws SQLException {
		ps.setObject(i, parameter.getValue());
	}

	@Override
	public E getNullableResult(ResultSet rs, String columnName) throws SQLException {
		if (Objects.isNull(rs.getObject(columnName))) {
			return null;
		}
		Object index = rs.getObject(columnName);
		return loadEnum(index);
	}

	@Override
	public E getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		if (Objects.isNull(rs.getObject(columnIndex))) {
			return null;
		}
		Object index = rs.getObject(columnIndex);
		return loadEnum(index);
	}

	@Override
	public E getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		if (Objects.isNull(cs.getObject(columnIndex))) {
			return null;
		}
		Object index = cs.getObject(columnIndex);
		return loadEnum(index);
	}

}
