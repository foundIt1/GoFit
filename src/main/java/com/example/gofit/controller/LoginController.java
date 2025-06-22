package com.example.gofit.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;
import com.example.gofit.model.UserModel;

public class LoginController {
    @FXML private TextField emailTextfield;
    @FXML private TextField passwordTextfield;
    @FXML private Button loginButton;
    @FXML private Hyperlink register_Hyperlink;
    @FXML private Hyperlink resetPassword_Hyperlink;
    @FXML private Label ErrorLabel;

    public void initialize() {
        ErrorLabel.setText("");
    }

    public void onRegister(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Register.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void onLoginButton(ActionEvent event) throws IOException {
        UserModel userModel = new UserModel();
        int isLogin = userModel.Login(emailTextfield.getText(), passwordTextfield.getText());
        if (isLogin == 0) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MainMenu.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            MainMenuController controller = loader.getController();
            controller.setUserModel(userModel);
            stage.setScene(new Scene(root));
            stage.show();
        } else if (isLogin == 1) {
            ErrorLabel.setText("Invalid Password");
        } else {
            ErrorLabel.setText("User does not exist");
        }
    }
}
