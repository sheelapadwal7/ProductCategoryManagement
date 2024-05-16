package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	public Product createProduct(Product product) {
		return productRepository.save(product);
	}

	public Product getProductById(Integer id) {
		return productRepository.findById(id).get();
	}

	public Product updateProduct(Integer id, Product product) {
		Product existingProduct = productRepository.findById(id).get();
		existingProduct.setName(product.getName());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setCategory(product.getCategory());
		return productRepository.save(existingProduct);
	}

	public void deleteProduct(Integer id) {
		Product product = productRepository.findById(id).get();
		productRepository.delete(product);
	}
}
