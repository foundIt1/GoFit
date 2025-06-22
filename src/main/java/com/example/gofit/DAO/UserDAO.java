package com.example.gofit.DAO;
import java.util.*;
import com.example.gofit.objects.User;
import java.io.*;

public class UserDAO {
    private final String filename = "user.dat";
    private Map<String, User> users;

    public UserDAO() {
        this.users = getAllUsers();
    }

    private Map<String, User> getAllUsers() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (Map<String, User>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new HashMap<>();
        }
    }

    public Map<String, User> getUsers() {
        return this.users;
    }

    public void addUser(User user) {
        this.users.put(user.getEmail(), user);
    }

    public void writeAllUsersToFile() {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(this.users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}