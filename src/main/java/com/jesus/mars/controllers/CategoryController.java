package com.jesus.mars.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jesus.mars.model.Category;
import com.jesus.mars.repositories.CategoryRepository;

import javassist.tools.web.BadHttpRequest;

@RestController
@RequestMapping(path = "/categories")
public class CategoryController {

	@Autowired
	private CategoryRepository repository;

	@GetMapping
	public Iterable<Category> findAll() {
		return repository.findAll();
	}

	@GetMapping(path = "/{id}")
	public Category find(@PathVariable("id") String id) {
		return repository.findOne(id);
	}

	@PostMapping(consumes = "application/json")
	public Category create(@RequestBody Category category) {
		return repository.save(category);
	}

	@DeleteMapping(path = "/{id}")
	public void delete(@PathVariable("id") String id) {
		repository.delete(id);
	}

	@PutMapping(path = "/{id}")
	public Category update(@PathVariable("id") String id, @RequestBody Category category) throws BadHttpRequest {
		if (repository.exists(id)) {
			return repository.save(category);
		} else {
			throw new BadHttpRequest();
		}
	}

}
