package com.jesus.mars.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jesus.mars.model.Category;
import com.jesus.mars.repositories.CategoryRepository;

import javassist.tools.web.BadHttpRequest;

@RestController
public class CategoryController {

	@Autowired
	private CategoryRepository repository;

	@GetMapping("/api/categories")
    public List<Category> getCategories() {
        return repository.findAll();
    }
	
	/*@GetMapping
	public Iterable<Category> findAll() {
		return repository.findAll();
	}*/

	@GetMapping("/api/categories/{categoryId}")
	public Category find(@PathVariable Long categoryId) {
		return repository.findOne(categoryId);
	}

	
	@PostMapping("/api/categories")
	public Category create(@RequestBody Category category) {
		return repository.save(category);
	}
	
	@PutMapping("/api/categories/{categoryId}")
	public Category update(@PathVariable Long categoryId, @RequestBody Category category) throws BadHttpRequest {
		if (repository.exists(categoryId)) {
			return repository.save(category);
		} else {
			throw new BadHttpRequest();
		}
	}

	@DeleteMapping("/api/categories/{categoryId}")
	public void delete(@PathVariable Long categoryId) {
		repository.delete(categoryId);
	}
	



}
