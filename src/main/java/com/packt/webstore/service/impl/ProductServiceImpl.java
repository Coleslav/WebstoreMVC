package com.packt.webstore.service.impl;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductRepository;
import com.packt.webstore.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.getAllProducts();
    }

    public Product getProductById(String ProductID){
        return productRepository.getProductById(ProductID);
    }

    public List<Product> getProductsByCategory(String category){
        return productRepository.getProductsByCategory(category);
    }

    public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
        return productRepository.getProductsByFilter(filterParams);
    }

    public List<Product> getProductsByManufacturer(String manufacturer){
        return productRepository.getProductsByManufacturer(manufacturer);
    }
}
