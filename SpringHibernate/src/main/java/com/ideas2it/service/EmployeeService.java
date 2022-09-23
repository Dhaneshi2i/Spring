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

    public Trainee getTraineeById(String employeeId);

    public Trainer getTrainerById(String employeeId);

    public void updateTrainee(Trainee trainee);

    public void updateTrainer(Trainer trainer);

    //void removeTraineeEmployee(int trainee_id);

    //void removeTrainerEmployee(int trainer_id);

    //void update(Employee employee);

    void removeTraineeEmployee(Trainee trainee);

    void removeTrainerEmployee(Trainer trainer);
}
