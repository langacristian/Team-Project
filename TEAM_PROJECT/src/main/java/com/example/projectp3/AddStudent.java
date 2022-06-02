package com.example.projectp3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.w3c.dom.events.MouseEvent;


import java.io.IOException;
import java.math.BigInteger;
import java.net.URL;
import java.sql.*;
import java.util.Date;
import java.util.ResourceBundle;

public class AddStudent implements Initializable,GoBack,GoToDiagram {

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField dbfirst_name;
    @FXML
    private TextField dblast_name;
    @FXML
    private TextField dbtfID;
    @FXML
    private TextField dbDOF;
    @FXML
    private TextField dbphonenr;
    @FXML
    private TextField dbe_mail;
    @FXML
    private TextField dbcounty;
    @FXML
    private TextField dbcity;
    @FXML
    private TextField dbsex;
    @FXML
    private TextField dbcnp;
    @FXML
    private TextField dbyr;
    @FXML
    private TextField dbgrp;
    @FXML
    private TableView<Student> tvStudents;
    @FXML
    private TableColumn<Student, String> tcFName;
    @FXML
    private TableColumn<Student, String> tcLName;
    @FXML
    private TableColumn<Student, Long> tcID;
    @FXML
    private TableColumn<Student, Date> tcDOR;
    @FXML
    private TableColumn<Student, Long> tcPhnNr;
    @FXML
    private TableColumn<Student, String> tcEmail;
    @FXML
    private TableColumn<Student, String> tcCounty;
    @FXML
    private TableColumn<Student, String> tcCity;
    @FXML
    private TableColumn<Student, String> Sex;
    @FXML
    private TableColumn<Student, Long> tcCNP;
    @FXML
    private TableColumn<Student, Long> tcYear;
    @FXML
    private TableColumn<Student, Long> tcGroup;
    @FXML
    private Button btnInsert;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnDel;




    public Connection getConnection() {

        Connection connection;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/study", "root", "abcdef");
            return connection;

        } catch (Exception x) {
            System.out.println(x.getMessage());
            return null;
        }

    }

    public ObservableList<Student> getStudentlist(){
        ObservableList<Student> studentlist = FXCollections.observableArrayList();
        Connection connection = getConnection();
        Statement stat;
        ResultSet res;
        Student students;
        try {
            stat = connection.createStatement();
            res = stat.executeQuery("SELECT * FROM students");
            while (res.next()) {
                students = new Student(res.getLong("Id"),res.getString("First_name"), res.getString("Last_name"),res.getDate("DOR"), res.getLong("PhoneNr"), res.getString("email"), res.getString("county"), res.getString("city"), res.getString("Sex"), res.getLong("CNP"), res.getLong("StdYear"), res.getLong("StdGroup"));
                studentlist.add(students);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentlist;
    }
    public void ShowStudents(){
        ObservableList<Student> list = getStudentlist();
        tcID.setCellValueFactory(new PropertyValueFactory<>("Id"));
        tcFName.setCellValueFactory(new PropertyValueFactory<>("First_name"));
        tcLName.setCellValueFactory(new PropertyValueFactory<>("Last_name"));
        tcDOR.setCellValueFactory(new PropertyValueFactory<>("DOR"));
        tcPhnNr.setCellValueFactory(new PropertyValueFactory<>("PhoneNr"));
        tcEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tcCounty.setCellValueFactory(new PropertyValueFactory<>("county"));
        tcCity.setCellValueFactory(new PropertyValueFactory<>("city"));
        Sex.setCellValueFactory(new PropertyValueFactory<>("Sex"));
        tcCNP.setCellValueFactory(new PropertyValueFactory<>("CNP"));
        tcYear.setCellValueFactory(new PropertyValueFactory<>("StdYear"));
        tcGroup.setCellValueFactory(new PropertyValueFactory<>("StdGroup"));


        tvStudents.setItems(list);

    }
    //I figured out how to add students
    public void InsertStudents() throws IOException {
        Connection connection = getConnection();
        Statement stat;
        try {
            stat = connection.createStatement();
            stat.executeUpdate("INSERT INTO students VALUES(" + dbtfID.getText() + ",'" + dbfirst_name.getText() + "','" + dblast_name.getText() + "','" + dbDOF.getText() + "','" + dbphonenr.getText() + "','" + dbe_mail.getText() + "','" + dbcounty.getText() + "','" + dbcity.getText() + "','" + dbsex.getText() + "','" + dbcnp.getText() + "'," + dbyr.getText() + "," + dbgrp.getText() + ")" );
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    public void UpdateStudents() throws IOException{
        Connection connection = getConnection();
        Statement stat;
        try{
            stat = connection.createStatement();
            stat.executeUpdate("UPDATE students SET First_Name = '" + dbfirst_name.getText() + "', Last_Name = '" + dblast_name.getText() + "', DOR = '" + dbDOF.getText() + "', PhoneNr = '" + dbphonenr.getText() + "', Email ='" + dbe_mail.getText() + "', County = '" + dbcounty.getText()  + "', City = '" + dbcity.getText() + "', Sex = '" + dbsex.getText() + "', CNP = '" + dbcnp.getText() + "', StdYear = " + dbyr.getText() + ", StdGroup = " + dbgrp.getText() + " WHERE id = " + dbtfID.getText() + "");
          } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void DeleteStudents() throws IOException{
        Connection connection = getConnection();
        Statement stat;
        try{
            stat = connection.createStatement();
            stat.executeUpdate("DELETE FROM students WHERE id =" + dbtfID.getText() + "");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    @FXML
    private void HandleButtons(ActionEvent event) throws IOException {
        if (event.getSource() == btnInsert){
            InsertStudents();
            ShowStudents();
        }
        else if (event.getSource() == btnUpdate){
            UpdateStudents();
            ShowStudents();
        }
        else if (event.getSource() == btnDel){
            DeleteStudents();
            ShowStudents();
        }

    }


    @Override
    public void switchToPrevious(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void switchToDiagram(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Project-Diagram.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ShowStudents();
    }
}
