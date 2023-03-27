package com.shopcart.ShopCart1erParcial.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shopcart.ShopCart1erParcial.entity.Item;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {

    List<Item> findByName(String name);

}