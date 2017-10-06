package com.packt.webstore.domain.repository;

import java.math.BigDecimal;
import java.util.*;

import com.packt.webstore.domain.Product;

public interface ProductRepository {
    List<Product> getAllProducts();

    Product getProductById(String productId);

    List<Product> getProductsByCategory(String category);

    Set<Product> getProductsByFilter(Map<String, List<String>> filterParams);

    List<Product> getProductsByManufacturer(String manufacturer);

    void addProduct(Product product);

}