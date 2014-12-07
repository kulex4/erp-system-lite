package com.erpsystem.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * Created on 07.12.2014.
 */
public class CompanyDetailsController {

    @FXML
    private Button backButton;

    @FXML
    private Button addDetails;

    @FXML
    private Button viewDetails;

    @FXML
    private void addDetailsButtonClick(ActionEvent event) {
        SceneNavigator.loadScene(SceneNavigator.CHOOSE_SPECIALIST_SCENE);
    }

    @FXML
    private void viewDetailsButtonClick(ActionEvent event) {
        SceneNavigator.loadScene(SceneNavigator.CHOOSE_SPECIALIST_SCENE);
    }

    @FXML
    private void backButtonClick(ActionEvent event) {
        SceneNavigator.loadScene(SceneNavigator.START_SCENE);
    }
}
