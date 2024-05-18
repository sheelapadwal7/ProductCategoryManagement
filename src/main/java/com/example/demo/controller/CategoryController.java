package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Category;
import com.example.demo.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping
	public Page<Category> getAllCategories(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {
		return categoryService.getAllCategories(page, size);
	}

	@PostMapping
	public ResponseEntity<String> createCategory(@RequestBody Category category) {
		categoryService.createCategory(category);
		return ResponseEntity.status(HttpStatus.CREATED).body("Category added successfully");
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getCategoryById(@PathVariable Integer id) {
		Category category = categoryService.getCategoryById(id);
		if (category != null) {
			return ResponseEntity.ok(category);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category not found");
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> updateCategory(@PathVariable Integer id, @RequestBody Category category) {
		boolean updated = categoryService.updateCategory(id, category);
		if (updated) {
			return ResponseEntity.ok("Category updated successfully");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category not found");
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCategory(@PathVariable Integer id) {
		boolean deleted = categoryService.deleteCategory(id);
		if (deleted) {
			return ResponseEntity.ok("Category deleted successfully");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category not found");
		}
	}
}
