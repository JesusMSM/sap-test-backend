package com.jesus.mars.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.jesus.mars.model.Category;

@RepositoryRestResource(path = "/categories")
public interface CategoryRepository extends JpaRepository<Category, String> {

}
