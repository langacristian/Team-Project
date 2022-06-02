package com.example.projectp3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.util.Properties;
import java.io.IOException;

public class HelloApplication extends Application {

    public void start(Stage stage) throws IOException {

            FXMLLoader loader=new FXMLLoader(getClass().getResource("hello-view.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root, 600,400);
            stage.setScene(scene);
            stage.show();
        }
                public static void main(String[] args)  {
                      launch(args);
                 }
    }
