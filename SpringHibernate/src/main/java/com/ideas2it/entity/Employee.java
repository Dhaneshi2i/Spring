package com.ideas2it.entity;

import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@MappedSuperclass
public class Employee {

    private String employeeId;
    private String firstName;
    private String lastName;

    private LocalDate dateOfBirth;

    private LocalDate dateOfJoining;
    private boolean isActiveEmployee = false;

    public Employee() {
    }

    public Employee(String firstName, String lastName, String employeeId, Boolean isActiveEmployee, String dateOfBirth,
                    String dateOfJoining) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeId = employeeId;
        this.isActiveEmployee=isActiveEmployee;
        this.dateOfBirth=LocalDate.parse(dateOfBirth);
        this.dateOfJoining=LocalDate.parse(dateOfJoining);
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = LocalDate.parse(dateOfBirth);
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(String dateOfJoining) {
        this.dateOfJoining = LocalDate.parse(dateOfJoining);
    }

    public void setActiveEmployee(Boolean activeEmployee) {
        isActiveEmployee = activeEmployee;
    }

}
