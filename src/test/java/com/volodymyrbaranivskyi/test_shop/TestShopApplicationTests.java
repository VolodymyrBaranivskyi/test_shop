package com.volodymyrbaranivskyi.test_shop;

import com.volodymyrbaranivskyi.test_shop.data.dao.impl.ProductDaoImpl;
import com.volodymyrbaranivskyi.test_shop.logic.services.impl.ProductServiceImpl;
import com.volodymyrbaranivskyi.test_shop.model.entities.Products;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

@EnableTransactionManagement
@SpringBootTest
@RunWith(SpringRunner.class)
class TestShopApplicationTests {

	@Autowired
	private ProductDaoImpl dao;

	@Autowired
	private ProductServiceImpl service;


	@Test
	void checkWorkingRegex() {

		Products product = new Products("Samsung Test2", "New phone model 14");
		Products product2 = new Products("Iphone Test2", "New phone model 14");

		dao.save(product);
		dao.save(product2);
		String regex = "Samsung";
		List<Products> productsList = service.getAllAvailable(regex);
		List<Products> resultProduct = productsList.stream().filter(productItem -> productItem.getName().equals("Iphone Test2")).collect(Collectors.toList());
		assertEquals(resultProduct.get(0).getName(), product2.getName());
	}

}
