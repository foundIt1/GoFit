package com.example.gofit;
import com.example.gofit.objects.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;
import com.example.gofit.DAO.UserDAO;

import java.util.Map;

public class Main extends Application{
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Login.fxml"));
        Parent root = loader.load();
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void Main(String[] args) {
        launch(args);
    }
}
