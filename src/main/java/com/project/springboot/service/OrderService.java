package com.project.springboot.service;

import com.project.springboot.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private ProductService productService;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${external.api.calling}")
    private String baseUrl;


    public String placeOrder(int productId){

        //Product product = productService.getProductByiId(productId);

        //logic microservice
        //String url = "http://localhost:8081/products/" + productId;

        String url = baseUrl + productId;



        Product product = restTemplate.getForObject(url, Product.class);

        return "Order Placed for :: " + product.getProductName()+ "product Prize :: " +product.getProductPrize();

    }

}
