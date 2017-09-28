package com.packt.webstore.controller;

//import java.math.BigDecimal;
import com.packt.webstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@Controller
@RequestMapping("/products")
public class ProductController {


    @Autowired
    private ProductService productService;

    @RequestMapping
    public String list(Model model) {
        model.addAttribute("products",productService.getAllProducts());
        return "products";
    }

    @RequestMapping("/all")
    public String allProducts(Model model){
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    @RequestMapping("/{category}")
    public String getProductsByCategory(Model model, @PathVariable("category")String productCategory){
        model.addAttribute("products", productService.getProductsByCategory(productCategory));
        return "products";
    }

    @RequestMapping("/filter/{ByCriteria}")
    public String getProductsByFilter(@MatrixVariable(pathVar = "ByCriteria")Map<String,List<String>> filterParams, Model model){
        model.addAttribute("products", productService.getProductsByFilter(filterParams));
        return "products";
    }

    @RequestMapping("/product")
    public String getProductById(@RequestParam("id") String productId, Model model) {
        model.addAttribute("product", productService.getProductById(productId));
        return "product";
    }

    @RequestMapping("/manufacturer")
    public String getProductByManufacturer(@RequestParam("manufacturer") String manufacturer, Model model) {
        model.addAttribute("product", productService.getProductsByManufacturer(manufacturer));
        return "products";
    }

    /*
    @RequestMapping("/{category}/{ByCriteria}/{manufacturer}")
    public String getProductsByCategory(@PathVariable("category")String productCategory,
                                        @MatrixVariable(pathVar = "ByCriteria")Map<String,List<String>> filterParams,
                                        @RequestParam("manufacturer") String manufacturer,
                                        Model model){

        model.addAttribute("products", productService.getProductsByCategory(productCategory));
        model.addAttribute("products", productService.getProductsByFilter(filterParams));
        model.addAttribute("products", productService.getProductsByManufacturer(manufacturer));
        return "products";
    }
    */
}
