package com.project.springboot.controller;

import com.project.springboot.model.CreditResponse;
import com.project.springboot.model.RecordRequestPayload;
import com.project.springboot.repo.RecordRepoClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class EmployeeControllerTest {

    @InjectMocks
    private EmployeeController employeeController;

    @Mock
    private RecordRepoClass recordRepoClass;

    @BeforeEach
    void setup(){

        MockitoAnnotations.openMocks(this);
    }

    // Write the junit testcase
   /* @Test
    void apiTesting_Test(){

        //mock data logic
        RecordRequestPayload recordRequestPayload = new RecordRequestPayload();
        recordRequestPayload.setAccountNumber(456789);
        recordRequestPayload.setCardNumber(1);
        recordRequestPayload.setCardHolderName("Suraj");
        recordRequestPayload.setDebitCardNumber(123456);
        when(recordRepoClass.save(recordRequestPayload)).thenReturn(recordRequestPayload);

        // method calling response

        CreditResponse creditResponse = employeeController.apiTesting(recordRequestPayload);

        // Assert equal

        assertEquals(HttpStatus.OK,creditResponse.getStatusCode());
        assertEquals("Data Successfully Store in DB",creditResponse.getMessage());

    }*/



}
