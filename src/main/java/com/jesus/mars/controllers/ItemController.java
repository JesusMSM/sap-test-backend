package com.jesus.mars.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jesus.mars.model.Category;
import com.jesus.mars.model.Item;
import com.jesus.mars.repositories.CategoryRepository;
import com.jesus.mars.repositories.ItemRepository;
import com.jesus.mars.util.ResourceNotFoundException;


@RestController
public class ItemController {

	@Autowired
	private ItemRepository repository;
	
	@Autowired
	private CategoryRepository catRepository;

	@GetMapping
	public Iterable<Item> findAll() {
		return repository.findAll();
	}

	@GetMapping("/categories/{categoryId}/items")
    public List<Item> getItemsByCategoryId(@PathVariable Long categoryId) {
        return repository.findByCategoryId(categoryId);
    }
	
	/*@GetMapping(path = "/{id}")
	public Item find(@PathVariable("id") Long id) {
		return repository.findOne(id);
	}*/

	@PostMapping("/categories/{categoryId}/items")
	public Item create(@PathVariable Long categoryId,
            @Valid @RequestBody Item item) {
		Category category = catRepository.findOne(categoryId);
		if (category.equals(null)) throw new ResourceNotFoundException("Category not found with id " + categoryId);
		item.setCategory(category);
		return repository.save(item);
	}

	@DeleteMapping("/categories/{categoryId}/items/{itemId}")
	public ResponseEntity<?> delete(@PathVariable Long categoryId,
            @PathVariable Long itemId) {
		if(catRepository.findOne(categoryId)==null) {
            throw new ResourceNotFoundException("Category not found with id " + categoryId);
        }
		if(repository.findOne(itemId)==null) {
            throw new ResourceNotFoundException("Item not found with id " + itemId);
        }
		
		repository.delete(itemId);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/categories/{categoryId}/items/{itemId}")
	public Item update(@PathVariable Long categoryId,
            @PathVariable Long itemId,
            @Valid @RequestBody Item itemRequest) {
		if(catRepository.findOne(categoryId)==null) {
            throw new ResourceNotFoundException("Category not found with id " + categoryId);
        }
		if(repository.findOne(itemId)==null) {
            throw new ResourceNotFoundException("Item not found with id " + itemId);
        }
		
		return repository.save(itemRequest);
		
	}

}
