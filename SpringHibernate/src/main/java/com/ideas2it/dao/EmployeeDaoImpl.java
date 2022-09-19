package com.ideas2it.dao;

import com.ideas2it.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
@Component
@EnableTransactionManagement
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    @Override
    public void saveOrUpdateEmployee(Employee employee){
        Session session = sessionFactory.getCurrentSession();
        session.persist(employee);
    }

    @Transactional
    @Override
    public List<Employee> getEmployee(){
        List<Employee> employees = new ArrayList<>();
        Session session = sessionFactory.getCurrentSession();
        TypedQuery query = session.getNamedQuery("findEmployee");
        employees = query.getResultList();
        return employees;
    }
    @Transactional
    @Override
    public Employee getEmployeeById(String employeeId) {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery query = session.getNamedQuery("findEmployeeById");
        query.setParameter("employeeId", employeeId);
        Employee employee = (Employee) query.getSingleResult();
        return employee;
    }
    @Transactional
    @Override
    public void update(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(employee);
    }
}
