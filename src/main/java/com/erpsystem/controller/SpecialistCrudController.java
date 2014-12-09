package com.erpsystem.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created on 09.12.2014.
 */
public class SpecialistCrudController implements Initializable {

    @FXML
    private Button backButton;

    @FXML
    private Button okButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void backButtonClick(ActionEvent event) {
        SceneNavigator.loadScene(SceneNavigator.SPECIALISTS_SCENE);
    }
}
