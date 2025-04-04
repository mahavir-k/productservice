package com.product.service.controller;

import com.product.service.dto.ProductRequest;
import com.product.service.dto.ProductResponse;
import com.product.service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/add")
    public ProductResponse saveProduct(@RequestBody ProductRequest product) {
        return service.saveProduct(product);
    }

    @GetMapping("/all")
    public List<ProductResponse> findProduct() {
        return service.findProduct();
    }

    @GetMapping("/detail/{id}")
    public ProductResponse readProduct(@PathVariable("id") int productId) {
        return service.readProduct(productId);
    }


}
