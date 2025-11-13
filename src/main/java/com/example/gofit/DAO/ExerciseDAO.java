package com.example.gofit.DAO;
import java.util.*;
import com.example.gofit.objects.Exercises;
import com.example.gofit.DAO.UserDAO;
import java.io.*;

public class ExerciseDAO {
    private final String filename = "exercises.dat";
    private Map<Integer, List<Exercises>> exercises;

    public ExerciseDAO() {
        this.exercises = getAllExercises();
    }

    private Map<Integer, List<Exercises>> getAllExercises() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (Map<Integer,List<Exercises>>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new HashMap<>();
        }
    }

    public Map<Integer, List<Exercises>> getExercises() {
        return this.exercises;
    }

    public void addExercise(int UID, Exercises exercise) {
        this.exercises.computeIfAbsent(UID, k -> new ArrayList<>()).add(exercise);
        writeAllUsersToFile();
    }

    public void writeAllUsersToFile() {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(this.exercises);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
