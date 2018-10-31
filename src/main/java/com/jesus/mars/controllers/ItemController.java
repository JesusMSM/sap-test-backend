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

import com.jesus.mars.model.Item;
import com.jesus.mars.repositories.ItemRepository;

import javassist.tools.web.BadHttpRequest;

@RestController
@RequestMapping(path = "/items")
public class ItemController {

	@Autowired
	private ItemRepository repository;

	@GetMapping
	public Iterable<Item> findAll() {
		return repository.findAll();
	}

	@GetMapping(path = "/{id}")
	public Item find(@PathVariable("id") String id) {
		return repository.findOne(id);
	}

	@PostMapping(consumes = "application/json")
	public Item create(@RequestBody Item item) {
		return repository.save(item);
	}

	@DeleteMapping(path = "/{id}")
	public void delete(@PathVariable("id") String id) {
		repository.delete(id);
	}

	@PutMapping(path = "/{id}")
	public Item update(@PathVariable("id") String id, @RequestBody Item item) throws BadHttpRequest {
		if (repository.exists(id)) {
			return repository.save(item);
		} else {
			throw new BadHttpRequest();
		}
	}

}
