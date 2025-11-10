package com.example.gofit.objects;

import java.io.Serializable;

public class Exercises implements Serializable{
    int exercise_id;
    int hour;
    int minute;
    String exercise_name;
    int calories_bph;
    double calories_burnt;

    public Exercises (int exercise_id, int hour, int minute, String exercise_name, int calories_bph) {
        this.exercise_id = exercise_id;
        this.hour = hour;
        this.minute = minute;
        this.exercise_name = exercise_name;
        this.calories_bph = calories_bph;
        this.calories_burnt = calc_calories_burnt();
    }

    private double calc_calories_burnt() {
        double minute_dec = (this.minute/60.0);
        double hour_dec = (this.hour + minute_dec);
        return (this.calories_bph * hour_dec);
    }
}
