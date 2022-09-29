package com.ideas2it.service;

import com.ideas2it.dao.LoginDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private LoginDao loginDao;

    public boolean findUser(String username, String password) {
        return loginDao.findUser(username, password);
    }
}
