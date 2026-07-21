package com.project.springboot.service;

import com.project.springboot.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class OrderServiceTest {

    @InjectMocks
    private OrderService orderService;

    @Mock
    private ProductService productService;

    @BeforeEach
    void setup(){

        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void placedOrderTest(){
        int productId = 1 ;
        Product product = new Product(1,"Mobile",10000);
        when(productService.getProductByiId(productId)).thenReturn(product);
        String result = orderService.placeOrder(productId);
        assertEquals("Order Placed for :: Mobile",result);
    }
}
