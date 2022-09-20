package com.ideas2it.entity;


import org.springframework.stereotype.Component;

import javax.persistence.*;

@NamedQueries(
        { @NamedQuery(
                name = "findEmployee",
                query = "from Employee"
        ),
        @NamedQuery(
                name = "findEmployeeById",
                query = "from Employee where employeeId = :employeeId"
        )}
)

@Component
@Entity
@Table(name="Employee")
public class Employee {

    @Id
    @GeneratedValue
    private int id;
    @Column
    private String employeeId;
    @Column
    private String firstName;
    @Column
    private String lastName;

    public Employee() {
    }

    public Employee(String firstName, String lastName, String employeeId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeId = employeeId;
    }

    public int getId() {
        return id;
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
}
