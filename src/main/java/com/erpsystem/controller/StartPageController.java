package com.erpsystem.controller;

import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * Created on 07.12.2014.
 */
public class StartPageController {

    @FXML
    private Button companyDetails;

    @FXML
    private Button workReports;

    @FXML
    private Button specialistsDetails;

    @FXML
    private void companyDetailsButtonClick(ActionEvent event) {
        SceneNavigator.loadScene(SceneNavigator.COMPANY_DETAILS_SCENE);
    }

    @FXML
    private void workReportsButtonClick(ActionEvent event) {
        SceneNavigator.loadScene(SceneNavigator.WORK_REPORTS_SCENE);
    }

    @FXML
    private void specialistsDetailsButtonClick(ActionEvent event) {
        SceneNavigator.loadScene(SceneNavigator.SPECIALISTS_SCENE);
    }
}
