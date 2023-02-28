package com.springboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import com.springboot.model.Product;

@Service
public class ProductService {

	public List<Product> getAllProducts() {

		List<Product> listOfProduct = new ArrayList<>();
		listOfProduct.add(new Product("122", "IPHONE", "This from Steve Jobs", 400.00, "Apple Inc"));
		listOfProduct.add(
				new Product("123", "HP ProBook", "This is High-End laptop for Gaming", 800.00, "Hewlett Packard Inc"));
		listOfProduct.add(new Product("124", "Hard Disk", "This for Storage purpose", 200.00, "Sandisk Inc"));
		return listOfProduct;
	}
	public Product getProductById(String id) {
		Predicate<Product> ById=p->p.getId().equals(id);
		return filterProducts(ById);
	}
	
	public Product filterProducts(Predicate<Product> strategy) {
		return getAllProducts().stream().filter(strategy).findFirst().orElse(null);
	}
}
