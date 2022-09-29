package com.ideas2it.dao;

import com.ideas2it.entity.Trainee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class LoginDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public boolean findUser(String username, String password){
        Session session = sessionFactory.getCurrentSession();
        boolean isValidUser = false;
        Query query = (Query) session.getNamedQuery("findUser");
        query.setParameter("user", username);
        query.setParameter("password", password);
        try {
            String userObject = (String) query.getSingleResult();
            if (userObject != null) {
                isValidUser = true;
            }
        } catch (Exception e) {
            isValidUser = false;
        }
        return isValidUser;
    }

}
