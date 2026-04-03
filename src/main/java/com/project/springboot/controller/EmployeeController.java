package com.project.springboot.controller;

import com.project.springboot.model.CreditResponse;
import com.project.springboot.model.Employee;
import com.project.springboot.model.RecordRequestPayload;
import com.project.springboot.repo.RecordRepoClass;
import com.project.springboot.service.EmployeeService;
import com.project.springboot.service.EncryptionAndDecryptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private RecordRepoClass recordRepoClass;

    @Autowired
    private EncryptionAndDecryptionService encryptionAndDecryptionService;


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
           // String creditCardMaskNumber = maskNumber(requestPayload.getCreditCardNumber());
           // requestPayload.setCreditCardNumber(creditCardMaskNumber);


            String accountHolderName = encryptionAndDecryptionService.encryptMethod(requestPayload.getCardHolderName());

            String[] splitPartTwoString1 = accountHolderName.split("SecretKey ::");
            //String[] splitPartTwoString = accountHolderName.split("encryption Key ::");

            String encrptionAccountHolderName = splitPartTwoString1[0].replaceAll("encryption Key ::","");
            String secretKeyData = splitPartTwoString1[1];


            requestPayload.setCardHolderName(encrptionAccountHolderName.trim());
            requestPayload.setScerectKey(secretKeyData.trim());

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

    @GetMapping("/getCreditCardInformation")
    public List<RecordRequestPayload> retriveAllData() throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {

        List<RecordRequestPayload> retriveAllDataFromDB = recordRepoClass.findAll();
        List<RecordRequestPayload> listOfAllData = new ArrayList<>();
        for(RecordRequestPayload requestPayload1 : retriveAllDataFromDB){

            RecordRequestPayload requestPayload = new RecordRequestPayload();
            requestPayload.setCardNumber(requestPayload1.getCardNumber());
            requestPayload.setCreditCardNumber(requestPayload1.getCreditCardNumber());
            requestPayload.setAccountNumber(requestPayload1.getAccountNumber());
            requestPayload.setCardHolderName(encryptionAndDecryptionService.DecryptMethod(requestPayload1.getCardHolderName(),requestPayload1.getScerectKey()));
            listOfAllData.add(requestPayload);

        }
        return listOfAllData;
    }
}