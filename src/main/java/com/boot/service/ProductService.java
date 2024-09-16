package com.boot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.dao.ProductRepository;
import com.boot.entity.Product;

@Service
public class ProductService {
	@Autowired
	 ProductRepository pro;
	
	public void addProduct(Product products) {
		pro.save(products);
	}
	public List<Product> getallProducts(){
		return pro.findAll();
	}
    
	public List<Product> findbyName(String name) {
		return pro.findByName(name);
	}
	
	public List<Product> findbyPricerange(int minprice,int maxprice) {
		return pro.findByPriceBetween(minprice,maxprice);
	}
	
	public Optional<Product> findbyId(int id) {
		return pro.findById(id);
	}
	
}
