package com.jesus.mars.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jesus.mars.model.Category;
import com.jesus.mars.model.Item;
import com.jesus.mars.repositories.CategoryRepository;
import com.jesus.mars.repositories.ItemRepository;

@Component
public class DataLoader {

    private CategoryRepository catRepo;
    private ItemRepository itemRepo;


    @Autowired
    public DataLoader(CategoryRepository categoryRepository, ItemRepository itemRepo) {
        this.catRepo = categoryRepository;
        this.itemRepo = itemRepo;
        Category cat = loadCategories();
        loadItems(cat);
    }

    private Category loadCategories() {
    	Category cat = new Category(1L,"Category 1", 1);
        catRepo.save(cat);
        catRepo.save(new Category(2L,"Category 2", 3));
        return cat;
    }
    
    private void loadItems(Category cat) {
        itemRepo.save(new Item(1L,"Item 1", "Description for item 1", 5.0, cat, cat.getId()));
    }
}