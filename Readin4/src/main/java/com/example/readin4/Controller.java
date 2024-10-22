package com.example.readin4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller {
    @FXML
    private TextField txtID, txtName, txtAge;

    @FXML
    public void addStudent() {
        String mssv = txtID.getText();
        String name = txtName.getText();
        int age = Integer.parseInt(txtAge.getText());

    }
  public void loadStudents(ActionEvent actionEvent) {
  }

  public void saveStudent(ActionEvent actionEvent) {
  }
}