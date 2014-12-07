package com.erpsystem.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * Created on 07.12.2014.
 */
public class SpecialistController {

    @FXML
    private Button backButton;

    @FXML
    private Button chooseSpecialist;

    @FXML
    private Button addSpecialist;

    @FXML
    private void chooseSpecialistButtonClick(ActionEvent event) {
        SceneNavigator.loadScene(SceneNavigator.CHOOSE_SPECIALIST_SCENE);
    }

    @FXML
    private void addSpecialistButtonClick(ActionEvent event) {
        SceneNavigator.loadScene(SceneNavigator.ADD_SPECIALIST_SCENE);
    }

    @FXML
    private void backButtonClick(ActionEvent event) {
        SceneNavigator.loadScene(SceneNavigator.START_SCENE);
    }
}
