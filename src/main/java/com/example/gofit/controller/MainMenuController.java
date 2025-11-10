package com.example.gofit.controller;

import com.example.gofit.model.UserModel;
import com.example.gofit.objects.User;
import com.jfoenix.controls.*;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class MainMenuController {
    private UserModel userModel;
    @FXML private JFXButton homeButton;
    @FXML private JFXButton mealButton;
    @FXML private AnchorPane slider;


    public void setUserModel(UserModel usermodel) {
        this.userModel = usermodel;
        setupWindow();
    }

    private void setupWindow() {
        for (User users: this.userModel.getUserDAO().getUsers().values()) {
            System.out.println(users.getEmail() + " " + users.getPassword() + " " + users.getUID() + "\n");
        }
        slider.setTranslateX(-176);
    }

    public void onHomeButtonClick() {
        
    }
}
