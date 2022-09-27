package com.ideas2it.service;

import com.ideas2it.entity.Employee;
import com.ideas2it.entity.Trainee;
import com.ideas2it.entity.Trainer;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface EmployeeService<T extends Employee> {

    void saveEmployee(T employee);

    List<Trainee> getTraineeEmployees();

    List<Trainer> getTrainerEmployees();

    Trainee getTraineeById(String employeeId);

    Trainer getTrainerById(String employeeId);

    void updateTrainee(Trainee trainee);
    void updateTrainer(Trainer trainer);

    Trainee getByTraineeId(int traineeId);
}
