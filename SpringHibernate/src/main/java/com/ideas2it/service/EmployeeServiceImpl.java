package com.ideas2it.service;

import com.ideas2it.dao.EmployeeDao;
import com.ideas2it.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeDao employeeDao;

    public void saveOrUpdateEmployee(Employee employee){
        employeeDao.saveOrUpdateEmployee(employee);
    }

    public List<Employee> getEmployee(){
        return employeeDao.getEmployee();
    }

    public Employee getEmployeeById(String employeeId){
        return employeeDao.getEmployeeById(employeeId);
    }
    public void update(Employee employee){
        Employee selectedEmployee = employeeDao.getEmployeeById(employee.getEmployeeId());
        selectedEmployee.setFirstName(employee.getFirstName());
        employeeDao.update(selectedEmployee);
    }
}
