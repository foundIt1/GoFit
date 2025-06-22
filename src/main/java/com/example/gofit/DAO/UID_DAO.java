package com.example.gofit.DAO;

import java.util.*;
import java.io.*;

public class UID_DAO {
    private final String filename = "uid.dat";
    private int uid;

    public UID_DAO() {
        this.uid = getUIDForConstructor();
    }

    private int getUIDForConstructor() {
        int uid;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))){
            uid = (int) ois.readObject();
        } catch(IOException | ClassNotFoundException e) {
            e.printStackTrace();
            uid = 0;
        }
        return uid;
    }

    public void generateNewUID() {
        this.uid++;
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(this.uid);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getCurrUid() {
        return this.uid;
    }
}
