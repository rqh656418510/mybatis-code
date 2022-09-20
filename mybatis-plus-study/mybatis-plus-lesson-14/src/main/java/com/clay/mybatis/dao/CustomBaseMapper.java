package com.clay.mybatis.dao;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface CustomBaseMapper<T> extends BaseMapper<T> {

	List<T> findAll();

}
