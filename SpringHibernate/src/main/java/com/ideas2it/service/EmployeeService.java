package com.ideas2it.service;

import com.ideas2it.entity.Employee;
import com.ideas2it.entity.Trainee;
import com.ideas2it.entity.Trainer;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface EmployeeService<T extends Employee> {

    public void saveEmployee(T employee);

    //public void saveOrUpdateEmployee(Employee employee);

    public List<Trainee> getTraineeEmployees();

    public List<Trainer> getTrainerEmployees();

    public Employee getEmployeeById(String employeeId);

    public void update(Employee employee);

    void removeEmployee(String employeeId);
}
