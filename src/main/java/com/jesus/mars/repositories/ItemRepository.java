package com.jesus.mars.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.jesus.mars.model.Item;

@RestResource(exported = false)
public interface ItemRepository extends JpaRepository<Item, String> {

}
