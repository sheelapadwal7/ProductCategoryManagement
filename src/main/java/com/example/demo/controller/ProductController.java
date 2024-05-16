package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	@PostMapping
	public Product createProduct(@RequestBody Product product) {
		return productService.createProduct(product);
	}

	@GetMapping("/{id}")
	public Product getProductById(@PathVariable Integer id) {
		return productService.getProductById(id);
	}

	@PutMapping("/{id}")
	public Product updateProduct(@PathVariable Integer id, @RequestBody Product product) {
		return productService.updateProduct(id, product);
	}

	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable Integer id) {
		productService.deleteProduct(id);
	}
}
