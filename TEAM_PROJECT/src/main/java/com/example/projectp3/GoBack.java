package com.example.projectp3;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public interface GoBack {
    public void switchToPrevious(ActionEvent event) throws IOException;
}
