package com.project.springboot.controller;

import com.project.springboot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/{productId}")
    public String order(@PathVariable int productId){
        return orderService.placeOrder(productId);
    }

}
