package com.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.boot.entity.Product;
import com.boot.service.ProductService;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

    @Autowired
     ProductService productService;

    @PostMapping("/add")
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }

    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return productService.getallProducts();
    }
    
    @GetMapping("/show-name/{name}")
    public List<Product> findbyName(@PathVariable String name){
        System.out.println("Searching for product with name: " + name);
        return productService.findbyName(name);
    }

    
    @GetMapping("/show-id/{id}")
    public Optional<Product> findById(@PathVariable int id){
    	return productService.findbyId(id);
    }
    
    @GetMapping("/price-between/{min}/{max}")
    public List<Product> pricebetween(@PathVariable int min ,@PathVariable int max){
    	return productService.findbyPricerange(min, max);
    }
    
}
