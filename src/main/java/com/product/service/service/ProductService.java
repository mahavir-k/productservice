package com.product.service.service;

import com.product.service.Repository.ProductRepository;
import com.product.service.dto.ProductRequest;
import com.product.service.dto.ProductResponse;
import com.product.service.entity.ProductEntity;
import com.product.service.util.ProductUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;


    public ProductResponse saveProduct(ProductRequest productRequest) {
        ProductEntity productEntity = new ProductEntity();
        ProductResponse response = new ProductResponse();;

        productEntity.setProductId(productRequest.getProductId());
        productEntity.setProductName(productRequest.getProductName());
        productEntity.setProductPrice(productRequest.getProductPrice());
        productEntity.setMfgDate(productRequest.getMfgDate());
        productEntity.setBrandName(productRequest.getBrandName());
        productEntity.setProductType(productRequest.getProductType());
        productEntity.setProductQuantity(productRequest.getProductQuantity());

        if (repository.existsById(productRequest.getProductId())) {
                    response.setStatus("Product id already exist.....!");
        } else {
            ProductEntity entity = repository.save(productEntity);

           /* response.setProductId(productEntity.getProductId());
            response.setProductType(productEntity.getProductType());
            response.setProductName(productEntity.getProductName());
            response.setBrandName(productEntity.getProductName());
            response.setMfgDate(productEntity.getMfgDate());
            response.setProductPrice(productEntity.getProductPrice());
            response.setProductQuantity(productEntity.getProductQuantity());*/
            ProductUtils.entityToResponseConverter(entity);
            response.setStatus("Product added successfully.....!");
        }
        return response;
    }

    public List<ProductResponse> findProduct() {
        List<ProductEntity> entities = repository.findAll();

        List<ProductResponse> list = new ArrayList<>();

        // For each loop
        for (ProductEntity entity : entities) {
            ProductResponse newObj = ProductUtils.entityToResponseConverter(entity);

           /* ProductResponse newObj = new ProductResponse();
            newObj.setProductId(entity.getProductId());
            newObj.setProductPrice(entity.getProductPrice());
            newObj.setProductName(entity.getProductName());
            newObj.setProductType(entity.getProductType());
            newObj.setProductQuantity(entity.getProductQuantity());
            newObj.setMfgDate(entity.getMfgDate());
            newObj.setBrandName(entity.getBrandName());*/

            list.add(newObj);
        }

        // for loop
        /*for(int i=0; i<= entities.size() ; i++){
            ProductResponse newObj = new ProductResponse();

        }*/
        return list;
    }

    /*private static ProductResponse entityToResponseConverter(ProductEntity entity) {
        ProductResponse newObj = new ProductResponse();
        newObj.setProductId(entity.getProductId());
        newObj.setProductPrice(entity.getProductPrice());
        newObj.setProductName(entity.getProductName());
        newObj.setProductType(entity.getProductType());
        newObj.setProductQuantity(entity.getProductQuantity());
        newObj.setMfgDate(entity.getMfgDate());
        newObj.setBrandName(entity.getBrandName());
        return newObj;
    }*/

    public ProductResponse readProduct(int productId) {

        Optional<ProductEntity> productEntity = repository.findById(productId);
        //ProductEntity productEntity = repository.findById(productId).get();

        ProductResponse response = new ProductResponse();
        if (productEntity.isPresent()) {
            ProductEntity entity = productEntity.get();
            response = ProductUtils.entityToResponseConverter(entity);
            /*response.setProductId(entity.getProductId());
            response.setProductPrice(entity.getProductPrice());
            response.setProductType(entity.getProductType());
            response.setProductName(entity.getProductName());
            response.setMfgDate(entity.getMfgDate());
            response.setProductQuantity(entity.getProductQuantity());
            response.setBrandName(entity.getBrandName());*/
        }
        return response;
    }

    public ProductResponse findByProductName(String productName) {
        ProductEntity entity = repository.findByProductName(productName);
        return ProductUtils.entityToResponseConverter(entity);
    }
}
