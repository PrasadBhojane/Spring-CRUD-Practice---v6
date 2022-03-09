package com.springboot.crud.v6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.crud.v6.entity.Product;
import com.springboot.crud.v6.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	public Product saveProduct(Product product) {
		return repository.save(product);
	}

	public List<Product> saveProducts(List<Product> products) {
		return repository.saveAll(products);
	}

	public List<Product> getProducts() {
		return repository.findAll();
	}

	public Product getProductById(Integer id) {
		return repository.findById(id).orElse(null);
	}

	public Product getProductByName(String name) {
		return repository.findByName(name);
	}

	public Product getProductByDiscount(Integer discount) {
		return repository.findByDiscount(discount);
	}

	public Product updateProduct(Product product) {
		Product existingProduct = repository.findById(product.getId()).orElse(null);
		existingProduct.setName(product.getName());
		existingProduct.setQty(product.getQty());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setDiscount(product.getDiscount());
		return repository.save(existingProduct);
	}

	public String deleteProduct(Integer id) {
		repository.deleteById(id);
		return "Product removed!! " + id;
	}
}
