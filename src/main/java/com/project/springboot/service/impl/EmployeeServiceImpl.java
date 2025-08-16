package com.project.springboot.service.impl;

import com.project.springboot.model.Employee;
import com.project.springboot.repo.EmployeeRepo;
import com.project.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public Employee createEmployee(Employee employeeList) {
        return employeeRepo.save(employeeList);
    }

    @Override
    public List<Employee> getEmployee() {
        return employeeRepo.findAll();
    }

    @Override
    public Optional<Employee> getIdWiseData(Integer id) {
       Optional<Employee> data = employeeRepo.findById(id);
       return data;
    }

    @Override
    public Employee updateEmployee(Employee employee,Integer id) {
        Employee employee1 = new Employee();
        employee1.setId(id);
        employee1.setName(employee.getName());
        employee1.setDepartment(employee.getDepartment());
        return employeeRepo.save(employee1);
    }

    @Override
    public String deleteEmployee(Integer id) {
        employeeRepo.deleteById(id);
        return "Employee Deleted Successfully : " + id;
    }
}
