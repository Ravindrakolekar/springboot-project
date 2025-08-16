package com.project.springboot.controller;

import com.project.springboot.model.Employee;
import com.project.springboot.repo.EmployeeRepo;
import com.project.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


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

    @GetMapping("/getEmployee")
    public List<Employee> getAllEmplyee(){
        return employeeService.getEmployee();
    }

    @GetMapping("/getSpecificId/{id}")
    public Optional<Employee> getSpecificData(@PathVariable Integer id){
        return employeeService.getIdWiseData(id);
    }

    @PutMapping("/updateEmployee/{id}")
    public Employee updateEmployee(@RequestBody Employee employee,@PathVariable Integer id){
        return employeeService.updateEmployee(employee,id);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable Integer id){
        return employeeService.deleteEmployee(id);
    }

}
