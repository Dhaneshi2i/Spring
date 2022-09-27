package com.ideas2it.dao;

import com.ideas2it.entity.Employee;
import com.ideas2it.entity.Trainee;
import com.ideas2it.entity.Trainer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDao<T extends Employee> {

    void saveEmployee(T employee);

    List<Trainee> getTraineeEmployees();

    List<Trainer> getTrainerEmployees();

    Trainee getTraineeById(String employeeId);

    Trainer getTrainerById(String employeeId);

    void updateTrainee(Trainee trainee);

    void updateTrainer(Trainer trainer);

    Trainee getByTraineeId(int traineeId);

    //Trainer getByTrainerId(int trainerId);
}
