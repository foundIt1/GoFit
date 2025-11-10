package com.example.gofit;

import com.example.gofit.DAO.UserDAO;
import com.example.gofit.objects.User;
import com.example.gofit.DAO.UID_DAO;

import java.util.Map;

public class MainView {
    public static void main(String[] args) {
        UserDAO user = new UserDAO();
        Map<String, User> usering = user.getUsers();
        for (User users: usering.values()) {
            System.out.println(users.getEmail() + " " + users.getPassword() + " " +  users.getUID());
        }
        UID_DAO uidDAO = new UID_DAO();
        System.out.println("\n\n\n" + uidDAO.getCurrUid());
    }
}
