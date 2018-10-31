package com.jesus.mars.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.jesus.mars.model.Item;

@RepositoryRestResource(path = "/items")
public interface ItemRepository extends JpaRepository<Item, String> {

}
