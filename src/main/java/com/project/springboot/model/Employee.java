package com.project.springboot.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import jakarta.persistence.*;

@Entity
//@Table(JsonAutoDetect.Value = "Employee_Table")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String department;
    private String hrDepartment;
    private String mail;
    private String createCardNumber;
    private String accountNumber;


    public void setId(Integer id) {
        this.id = id;
    }

    public String getHrDepartment() {
        return hrDepartment;
    }

    public void setHrDepartment(String hrDepartment) {
        this.hrDepartment = hrDepartment;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getCreateCardNumber() {
        return createCardNumber;
    }

    public void setCreateCardNumber(String createCardNumber) {
        this.createCardNumber = createCardNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
