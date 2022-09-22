package com.ideas2it.entity;


import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Employee {

    private String employeeId;
    private String firstName;
    private String lastName;
    private boolean isActiveEmployee = false;

    public Employee() {
    }

    public Employee(String firstName, String lastName, String employeeId, Boolean isActiveEmployee) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeId = employeeId;
        this.isActiveEmployee=isActiveEmployee;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public Boolean getActiveEmployee() {
        return isActiveEmployee;
    }

    public void setActiveEmployee(Boolean activeEmployee) {
        isActiveEmployee = activeEmployee;
    }

    @Override
    public String toString() {
        return "First_Name: "+ getFirstName() + " Last_Name:"+ getLastName();
    }
}
