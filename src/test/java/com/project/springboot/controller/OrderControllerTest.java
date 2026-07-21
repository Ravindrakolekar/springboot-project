package com.project.springboot.controller;

import com.project.springboot.service.OrderService;
import com.project.springboot.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class OrderControllerTest {

    @InjectMocks
    private OrderController orderController;

    @Mock
    private OrderService orderService;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }

  @Test
    public void order_Test(){


        int productId = 1; // dummy data

        when(orderService.placeOrder(productId)).thenReturn("Order Placed for :: Mobile");
        String result = orderController.order(productId);
        assertEquals("Order Placed for :: Mobile",result);

    }


}
