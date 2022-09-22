package com.ideas2it.dao;

import com.ideas2it.entity.Employee;
import com.ideas2it.entity.Trainee;
import com.ideas2it.entity.Trainer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDaoImpl<T extends Employee> implements EmployeeDao<T> {

    @Autowired
    private SessionFactory sessionFactory;

    private T employee;

    @Transactional
    @Override
    public void saveEmployee(T employee) {
        Session session = sessionFactory.getCurrentSession();
        if (employee instanceof Trainee) {
            session.save((Trainee) employee);
            System.out.println(employee.getFirstName() + "Employee saved,");
        } else {
            session.save((Trainer) employee);
        }
    }

    @Transactional
    @Override
    public List<Trainee> getTraineeEmployees() {
        List<Trainee> trainees = new ArrayList<>();
        Session session = sessionFactory.getCurrentSession();
        Query query = session.getNamedQuery("findTrainee");
        query.setParameter("isActiveEmployee", false);
        //trainees = query.getResultList();
        //return (List<Trainee>) trainees;
        return (List<Trainee>) query.getResultList();
    }

    @Transactional
    @Override
    public List<Trainer> getTrainerEmployees() {
        List<Trainer> trainers = new ArrayList<>();
        Session session = sessionFactory.getCurrentSession();
        Query query = session.getNamedQuery("findTrainer");
        query.setParameter("isActiveEmployee", false);
        //trainers = query.getResultList();
        //return (List<Trainer>) trainers;
        return (List<Trainer>)query.getResultList();
    }

    @Transactional
    @Override
    public Employee getEmployeeById(String employeeId) {
        Employee selectedEmployee = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            if (employee instanceof Trainee) {
                Query query = (Query) session.getNamedQuery("findTraineeById");
                query.setParameter("employeeId", employeeId);
                query.setParameter("isActiveEmployee", false);
                //return (Trainee) query.getSingleResult();
                selectedEmployee = (Trainee) query.getSingleResult();
            } else {
                Query query = (Query) session.getNamedQuery("findTrainerById");
                query.setParameter("employeeId", employeeId);
                query.setParameter("isActiveEmployee", false);
                //Trainer trainer = (Trainer) query.getSingleResult();
                //return (Trainer) query.getSingleResult();
                selectedEmployee = (Trainer) query.getSingleResult();
            }
        } catch (NoResultException noResultException) {
            System.out.println(noResultException + "No such result");
        }
        return selectedEmployee;
    }
    @Transactional
    @Override
    public void update(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.update(employee);
    }

    @Transactional
    @Override
    public void removeEmployee(String employeeId) {
        Session session = sessionFactory.getCurrentSession();
        Employee employee = getEmployeeById(employeeId);
        session.delete(employee);
    }

}
    /*@Transactional
    @Override
    public List<Employee> getEmployee() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> root = criteriaQuery.from(Employee.class);
        criteriaQuery.select(root);
        Query query = session.createQuery(criteriaQuery);
        return (List<Employee>)query.getResultList();
    }
    @Transactional
    @Override
    public Employee getEmployeeById(String employeeId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = (Query) session.getNamedQuery("findEmployeeById");
        query.setParameter("employeeId", employeeId);
        query.setParameter("isActiveEmployee",false);
        //Employee employee = (Employee) query.getSingleResult();
        return (Employee) query.getSingleResult();
    }
    @Transactional
    @Override
    public void update(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.update(employee);
    }
    @Transactional
    @Override
    public void removeEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(employee);
    }*/

