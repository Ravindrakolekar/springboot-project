package com.project.springboot.service;

import com.project.springboot.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Employee createEmployee(Employee employeeList);

    List<Employee> getEmployee();

    Optional<Employee> getIdWiseData(Integer id);

    Employee updateEmployee(Employee employee,Integer id);

    String deleteEmployee(Integer id);
}
