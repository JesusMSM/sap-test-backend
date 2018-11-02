package com.jesus.mars.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jesus.mars.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
