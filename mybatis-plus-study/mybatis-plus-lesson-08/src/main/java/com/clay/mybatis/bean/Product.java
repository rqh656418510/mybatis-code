package com.clay.mybatis.bean;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.Version;

public class Product {

	private Long id;

	private String name;

	private BigDecimal price;
	
	@Version
	private Long version;

	public Product() {

	}

	public Product(String name, BigDecimal price) {
		super();
		this.name = name;
		this.price = price;
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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", version=" + version + "]";
	}

}
