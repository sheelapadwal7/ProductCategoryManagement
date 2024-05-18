package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping
	public Page<Product> getAllProducts(
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {
		return productService.getAllProducts(page, size);
	}

	@PostMapping
	public ResponseEntity<String> createProduct(@RequestBody Product product) {
		productService.createProduct(product);
		return new ResponseEntity<>("Product added successfully.", HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Integer id) {
		Product product = productService.getProductById(id);
		if (product != null) {
			return new ResponseEntity<>(product, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> updateProduct(@PathVariable Integer id, @RequestBody Product product) {
		boolean updated = productService.updateProduct(id, product);
		if (updated) {
			return new ResponseEntity<>("Product updated successfully.", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Product not found.", HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable Integer id) {
		boolean deleted = productService.deleteProduct(id);
		if (deleted) {
			return new ResponseEntity<>("Product deleted successfully.", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Product not found.", HttpStatus.NOT_FOUND);
		}
	}
}
