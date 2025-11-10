package com.example.gofit.objects;

import com.example.gofit.objects.Exercises;

public class BJJ extends Exercises{

    private static final int exercise_id = 00001;
    private static final int calories_bph = 600;
    private static final String exercise_name = "Brazilian Jiu Jitsu";

    public BJJ (int hour, int minute) {
        super(exercise_id, hour, minute, exercise_name, calories_bph);
    }
}
