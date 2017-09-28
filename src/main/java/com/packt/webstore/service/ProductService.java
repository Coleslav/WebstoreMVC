package com.packt.webstore.service;

import com.packt.webstore.domain.Product;
import java.util.*;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(String productID);
    List<Product> getProductsByCategory(String category);
    Set<Product> getProductsByFilter(Map<String, List<String>> filterParams);
    List<Product> getProductsByManufacturer(String manufacturer);
}
