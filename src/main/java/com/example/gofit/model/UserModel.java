package com.example.gofit.model;
import com.example.gofit.DAO.UserDAO;
import com.example.gofit.objects.User;
import com.example.gofit.DAO.UID_DAO;

import java.util.Map;

public class UserModel {
    User currUser;
    UserDAO userDAO;

    public UserModel () {
        this.currUser = null;
        this.userDAO = null;
    }

    public boolean Register (String email, String password) {
        UserDAO userDAO = new UserDAO();
        UID_DAO uidDAO = new UID_DAO();
        User newUser = new User(email, password, uidDAO.getCurrUid());
        boolean isRegistered;
        if (!(userDAO.getUsers().containsKey(newUser.getEmail()))) {
            userDAO.addUser(newUser);
            userDAO.writeAllUsersToFile();
            uidDAO.generateNewUID();
            isRegistered = true;
        } else {
            isRegistered = false;
        }
        Map<String, User> users = userDAO.getUsers();
        for (User user: users.values()) {
            System.out.println("User email: " + user.getEmail() + " User password: " + user.getPassword());
        }
        return isRegistered;
    }

    public int Login(String email, String password) {
        int isLogin;
        UserDAO userDAO = new UserDAO();
        if (userDAO.getUsers().containsKey(email)) {
            if (password.equals(userDAO.getUsers().get(email).getPassword())) {
                this.userDAO = userDAO;
                this.currUser = userDAO.getUsers().get(email);
                isLogin = 0;
            } else {
                isLogin = 1;
            }
        } else {
            isLogin = 2;
        }
        return isLogin;
    }

    public User getCurrUser() {
        return this.currUser;
    }

    public UserDAO getUserDAO() {
        return this.userDAO;
    }
}
