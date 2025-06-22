package com.example.gofit.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

import com.example.gofit.model.UserModel;

public class RegisterController {
    @FXML
    private TextField Email_field;
    @FXML
    private TextField Password_field;
    @FXML
    private TextField Reenter_field;
    @FXML
    private Button Register_button;
    @FXML
    private Label error_Label;

    public void onRegister(ActionEvent event) throws IOException {
        UserModel userModel = new UserModel();
        error_Label.setText("");
        if (Email_field.getText().isBlank() || Password_field.getText().isBlank() || Reenter_field.getText().isBlank()) {
            error_Label.setText("Please fill in all fields");
        } else if (Password_field.getText().equals(Reenter_field.getText())) {
            if (userModel.Register(Email_field.getText(), Password_field.getText()) == true) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Login.fxml"));
                Parent root = loader.load();
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.show();
            } else {
                error_Label.setText("Email already in use");
            }
        } else {
            error_Label.setText("Passwords do not match");
        }
    }
}
