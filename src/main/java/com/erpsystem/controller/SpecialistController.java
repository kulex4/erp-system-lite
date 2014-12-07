package com.erpsystem.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javax.swing.table.TableColumn;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created on 07.12.2014.
 */
public class SpecialistController implements Initializable {

    @FXML
    private Button backButton;

    @FXML
    private Button addButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button modifyButton;

    @FXML
    private Button moreInfoButton;

    public SpecialistController() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void addButtonClick(ActionEvent event) {

    }

    @FXML
    private void deleteButtonClick(ActionEvent event) {

    }

    @FXML
    private void modifyButtonClick(ActionEvent event) {

    }

    @FXML
    private void moreInfoButtonClick(ActionEvent event) {

    }

    @FXML
    private void backButtonClick(ActionEvent event) {
        SceneNavigator.loadScene(SceneNavigator.START_SCENE);
    }
}
