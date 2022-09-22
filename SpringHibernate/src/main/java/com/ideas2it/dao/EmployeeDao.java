package com.ideas2it.dao;

import com.ideas2it.entity.Employee;
import com.ideas2it.entity.Trainee;
import com.ideas2it.entity.Trainer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDao<T extends Employee> {

    void saveEmployee(T employee);

    //public void saveOrUpdateEmployee(Employee employee);

    public List<Trainee> getTraineeEmployees();

    public List<Trainer> getTrainerEmployees();

    public Employee getEmployeeById(String employeeId);

    public void update(Employee employee);

    public void removeEmployee(String employeeId);


}
