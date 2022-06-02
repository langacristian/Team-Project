package com.example.projectp3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements GoToDiagram,GoToManager {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @Override
    public void switchToDiagram(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Project-Diagram.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    @Override
    public void switchToStMng(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Add-Student.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }


}