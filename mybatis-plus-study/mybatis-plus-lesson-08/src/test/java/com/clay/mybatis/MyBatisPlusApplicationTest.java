package com.clay.mybatis;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.clay.mybatis.bean.Product;
import com.clay.mybatis.dao.ProductMapper;

@SpringBootTest
public class MyBatisPlusApplicationTest {

	@Autowired
	private ProductMapper productMapper;

	@Test
	public void updatePrice() {

		Product product1 = productMapper.selectById(1L);
		System.out.println("小李取出的商品价格:" + product1.getPrice());

		Product product2 = productMapper.selectById(1L);
		System.out.println("小王取出的商品价格:" + product2.getPrice());

		product1.setPrice(product1.getPrice().add(new BigDecimal(50)));
		int result1 = productMapper.updateById(product1);
		System.out.println("小李修改商品价格的结果: " + (result1 > 0));

		product2.setPrice(product2.getPrice().subtract(new BigDecimal(30)));
		int result2 = productMapper.updateById(product2);
		System.out.println("小王修改商品价格的结果: " + (result2 > 0));

		if (result2 == 0) {
			Product productNew = productMapper.selectById(1L);
			productNew.setPrice(productNew.getPrice().subtract(new BigDecimal(30)));
			int resultNew = productMapper.updateById(productNew);
			System.out.println("小王第二次修改商品价格的结果: " + (resultNew > 0));
		}

		Product product3 = productMapper.selectById(1L);
		System.out.println("最终的商品价格: " + product3.getPrice());
	}

}
