package com.example.gofit.objects;

import java.io.Serializable;

public class User implements Serializable {
    String email;
    String password;
    int UID;

    public User(String email, String password, int UID) {
        this.email = email;
        this.password = password;
        this.UID = UID;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public int getUID() {
        return this.UID;
    }
}
