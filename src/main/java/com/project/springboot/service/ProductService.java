package com.project.springboot.service;

import com.project.springboot.model.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    public Product getProductByiId(int productId){

        return new Product(productId,"Mobile",50000);
    }
}
