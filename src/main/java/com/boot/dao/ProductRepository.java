package com.boot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	

	List<Product> findByPriceBetween(int minprice, int maxprice);

	List<Product> findByName(String name);

}
