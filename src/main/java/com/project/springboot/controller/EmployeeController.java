package com.project.springboot.controller;

import com.project.springboot.model.CreditResponse;
import com.project.springboot.model.Employee;
import com.project.springboot.model.RecordRequestPayload;
import com.project.springboot.repo.RecordRepoClass;
import com.project.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private RecordRepoClass recordRepoClass;


    @GetMapping("/test")
    public String testData() {

        return "welcome spring boot application";
    }

    @PostMapping("/createEmployee")
    public Employee createEmployee(@RequestBody Employee employeeList) {

        return employeeService.createEmployee(employeeList);
    }

    @GetMapping("/getEmployee")
    public List<Employee> getAllEmplyee() {
        return employeeService.getEmployee();
    }

    @GetMapping("/getSpecificId/{id}")
    public Optional<Employee> getSpecificData(@PathVariable Integer id) {
        return employeeService.getIdWiseData(id);
    }

    @PutMapping("/updateEmployee/{id}")
    public Employee updateEmployee(@RequestBody Employee employee, @PathVariable Integer id) {
        return employeeService.updateEmployee(employee, id);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable Integer id) {
        return employeeService.deleteEmployee(id);
    }

    //New Api For credit card information
    @PostMapping("/creditInformation")
    public CreditResponse apiTesting(@RequestBody RecordRequestPayload requestPayload) {


        try{
            String creditCardMaskNumber = maskNumber(requestPayload.getCreditCardNumber());
            requestPayload.setCreditCardNumber(creditCardMaskNumber);

            recordRepoClass.save(requestPayload);
            CreditResponse creditResponse = new CreditResponse();
            creditResponse.setStatusCode(HttpStatus.OK);
            creditResponse.setMessage("Data Successfully Store in DB");
            return creditResponse;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    private String maskNumber(String creditCardNumber) {
        //logic simple
        String maskNumber = "****" + creditCardNumber.substring(4);
        return maskNumber;

    }
}