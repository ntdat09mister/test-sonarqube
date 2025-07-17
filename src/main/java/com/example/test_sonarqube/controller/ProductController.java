package com.example.test_sonarqube.controller;

import com.example.test_sonarqube.entity.Product;
import com.example.test_sonarqube.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    private ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/allProducts")
    public List<Product> productList() {
        return productService.getAllProducts();
    }
}
