package com.mpk.testportal.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpk.testportal.model.Product;

@Service
public class ProductService {

	private List<Product> list = new ArrayList<>();
	
	private Logger logger =  LoggerFactory.getLogger(ProductService.class);

	@Autowired
	private ProductServiceClient productServiceClient;

	public List<Product> getAllProducts() {

		list.add(new Product("123", "IPHONE X", "Brand New IPHONE X", 400.46, "Apple Inc", ""));
		list.add(new Product("124", "Samsung Y", "Latest Samsung Gen 5", 250.46, "Samsung Inc", ""));
		list.add(new Product("125", "LG  Z", "Next Gen LG Z", 100.46, "LG Inc", ""));

		return list;

	}

	public Product getProductById(String id) {
		if (list.isEmpty()) {
			list = getAllProductsFromRemoteService();
		}

		Predicate<Product> productById = p -> p.getId().equals(id);
		return list.stream().filter(productById).findFirst().orElse(null);

	}

	public List<Product> getAllProductsFromRemoteService() {

		logger.info("Before calling Product micro service  ....");
		List<Product> productList = productServiceClient.getAllProductsFromService();
		logger.info("After  calling Product micro service  ....");
		return productList;

	}

}
