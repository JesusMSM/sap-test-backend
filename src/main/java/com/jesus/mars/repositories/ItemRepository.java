package com.jesus.mars.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jesus.mars.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
	List<Item> findByCategoryId(Long categoryId);
}
