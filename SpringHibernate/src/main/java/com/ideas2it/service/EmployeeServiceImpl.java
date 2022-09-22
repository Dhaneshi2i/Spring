package com.ideas2it.service;

import com.ideas2it.dao.EmployeeDao;
import com.ideas2it.entity.Employee;
import com.ideas2it.entity.Trainee;
import com.ideas2it.entity.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl<T extends Employee> implements EmployeeService<T> {


    private T employee;

    @Autowired
    EmployeeDao  employeeDao;

    @Override
    public void saveEmployee(T employee) {
        if (employee instanceof Trainee) {
            employeeDao.saveEmployee((Trainee) employee);
        } else {
            employeeDao.saveEmployee((Trainer) employee);
        }
    }

    /*@Override
    @Transactional
    public void saveOrUpdateEmployee(Employee employee){
        employeeDao.saveOrUpdateEmployee(employee);
    }*/

    @Override
    @Transactional
    public List<Trainee> getTraineeEmployees(){
        return (List<Trainee>) employeeDao.getTraineeEmployees();
    }

    @Override
    @Transactional
    public List<Trainer> getTrainerEmployees(){
        return (List<Trainer>) employeeDao.getTrainerEmployees();
    }
    @Override
    @Transactional
    public Employee getEmployeeById(String employeeId){
        return employeeDao.getEmployeeById(employeeId);
    }

    @Override
    @Transactional
    public void update(Employee employee){
        Employee selectedEmployee = employeeDao.getEmployeeById(employee.getEmployeeId());
        selectedEmployee.setFirstName(employee.getFirstName());
        employeeDao.update(selectedEmployee);
    }

    @Override
    @Transactional
    public void removeEmployee(String employeeId) {
        employeeDao.removeEmployee(employeeId);
    }
}
