package com.ideas2it.dao;

import com.ideas2it.entity.Employee;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public interface EmployeeDao {
    public void saveOrUpdateEmployee(Employee employee);

    public List<Employee> getEmployee();

    @Transactional
    public Employee getEmployeeById(String employeeId);

    public void update(Employee employee);

    public void removeEmployee(Employee employee);


}
