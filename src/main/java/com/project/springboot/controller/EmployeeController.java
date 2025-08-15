package com.project.springboot.controller;

import com.project.springboot.model.Employee;
import com.project.springboot.repo.EmployeeRepo;
import com.project.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/test")
    public String testData(){
        return "welcome spring boot application";
    }

    @PostMapping("/createEmployee")
    public Employee createEmployee(@RequestBody Employee employeeList){
       return employeeService.createEmployee(employeeList);
    }
}
