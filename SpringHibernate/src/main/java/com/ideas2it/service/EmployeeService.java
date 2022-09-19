package com.ideas2it.service;

import com.ideas2it.entity.Employee;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public interface EmployeeService {
    public void saveOrUpdateEmployee(Employee employee);

    public List<Employee> getEmployee();

    public Employee getEmployeeById(String employeeId);

    public void update(Employee employee);
}
