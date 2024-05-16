package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

	public Category createCategory(Category category) {
		return categoryRepository.save(category);
	}

	public Category getCategoryById(Integer id) {
		return categoryRepository.findById(id).get();
	}

	public Category updateCategory(Integer id, Category category) {
		Category existingCategory = categoryRepository.findById(id).get();
		existingCategory.setName(category.getName());
		return categoryRepository.save(existingCategory);
	}

	public void deleteCategory(Integer id) {
		Category category = categoryRepository.findById(id).get();
		categoryRepository.delete(category);
	}
}
