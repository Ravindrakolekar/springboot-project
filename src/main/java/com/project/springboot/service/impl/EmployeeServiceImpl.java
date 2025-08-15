package com.project.springboot.service.impl;

import com.project.springboot.model.Employee;
import com.project.springboot.repo.EmployeeRepo;
import com.project.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public Employee createEmployee(Employee employeeList) {
        return employeeRepo.save(employeeList);
    }
}
