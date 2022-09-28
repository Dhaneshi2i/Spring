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
    private EmployeeDao  employeeDao;

    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public void saveEmployee(T employee) {
        if (employee instanceof Trainee) {
            employeeDao.saveEmployee((Trainee) employee);
        } else {
            employeeDao.saveEmployee((Trainer) employee);
        }
    }

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
    public Trainee getTraineeById(String employeeId) {
        return (Trainee) employeeDao.getTraineeById(employeeId);
    }

    @Override
    public Trainer getTrainerById(String employeeId) {
        return (Trainer) employeeDao.getTrainerById(employeeId);
    }
    @Override
    public void updateTrainee( Trainee trainee){
        employeeDao.updateTrainee(trainee);
    }

    @Override
    public void updateTrainer(Trainer trainer) {
        employeeDao.updateTrainer(trainer);
    }

    @Override
    public Trainee getByTraineeId(int traineeId) {
        return (Trainee) employeeDao.getByTraineeId(traineeId);
    }
}
