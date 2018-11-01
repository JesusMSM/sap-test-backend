package com.jesus.mars.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

	@GetMapping("/categories")
    public Page<Category> getCategories(Pageable pageable) {
        return repository.findAll(pageable);
    }
	
	/*@GetMapping
	public Iterable<Category> findAll() {
		return repository.findAll();
	}*/

	@GetMapping("/categories/{categoryId}")
	public Category find(@PathVariable Long categoryId) {
		return repository.findOne(categoryId);
	}

	
	@PostMapping("/categories")
	public Category create(@RequestBody Category category) {
		return repository.save(category);
	}
	
	@PutMapping("/categories/{categoryId}")
	public Category update(@PathVariable Long categoryId, @RequestBody Category category) throws BadHttpRequest {
		if (repository.exists(categoryId)) {
			return repository.save(category);
		} else {
			throw new BadHttpRequest();
		}
	}

	@DeleteMapping("/categories/{categoryId}")
	public void delete(@PathVariable Long categoryId) {
		repository.delete(categoryId);
	}
	



}
