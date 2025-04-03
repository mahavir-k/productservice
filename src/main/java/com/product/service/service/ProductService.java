package com.product.service.service;

import com.product.service.Repository.ProductRepository;
import com.product.service.dto.ProductRequest;
import com.product.service.dto.ProductResponse;
import com.product.service.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public ProductResponse saveProduct(ProductRequest productRequest){
        ProductEntity productEntity=new ProductEntity();

        productEntity.setProductId(productRequest.getProductId());
        productEntity.setProductName(productRequest.getProductName());
        productEntity.setProductPrice(productRequest.getProductPrice());
        productEntity.setMfgDate(productRequest.getMfgDate());
        productEntity.setBrandName(productRequest.getBrandName());
        productEntity.setProductType(productRequest.getProductType());
        productEntity.setProductQuantity(productRequest.getProductQuantity());

        ProductEntity entity=repository.save(productEntity);

        ProductResponse response=new ProductResponse();

        response.setProductId(productEntity.getProductId());
        response.setProductType(productEntity.getProductType());
        response.setProductName(productEntity.getProductName());
        response.setBrandName(productEntity.getProductName());
        response.setMfgDate(productEntity.getMfgDate());
        response.setProductPrice(productEntity.getProductPrice());
        response.setProductQuantity(productEntity.getProductQuantity());

        return response;
    }
}
