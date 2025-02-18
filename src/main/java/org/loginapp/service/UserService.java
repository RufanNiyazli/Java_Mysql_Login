package org.loginapp.service;

import org.loginapp.dao.UserDAO;

public class UserService {
    private UserDAO userDAO=new UserDAO();
    public boolean registerUser(String username ,String password){
       return userDAO.registerUser(username,password);

    }
    public  boolean loginUser(String username,String password){
        return userDAO.registerUser(username,password);
    }
}
