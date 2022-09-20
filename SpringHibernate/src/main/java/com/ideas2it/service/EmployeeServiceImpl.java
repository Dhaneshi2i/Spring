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
    @Override
    public void saveOrUpdateEmployee(Employee employee){
        employeeDao.saveOrUpdateEmployee(employee);
    }
    @Override
    public List<Employee> getEmployee(){
        return employeeDao.getEmployee();
    }
    @Override
    public Employee getEmployeeById(String employeeId){
        return employeeDao.getEmployeeById(employeeId);
    }

    @Override
    public void update(Employee employee){
        Employee selectedEmployee = employeeDao.getEmployeeById(employee.getEmployeeId());
        selectedEmployee.setFirstName(employee.getFirstName());
        employeeDao.update(selectedEmployee);
    }

    @Override
    public void removeEmployee(Employee employee) {
        employeeDao.removeEmployee(employee);
    }
}
