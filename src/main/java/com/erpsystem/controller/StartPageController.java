package com.erpsystem.controller;

import com.erpsystem.dao.CompanyDao;
import com.erpsystem.dao.CompanyDaoImpl;
import com.erpsystem.model.Company;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created on 07.12.2014.
 */
public class StartPageController implements Initializable {

    @FXML
    private Button companyDetails;

    @FXML
    private Button workReports;

    @FXML
    private Button specialistsDetails;

    @FXML
    private Label description;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        CompanyDao companyDao = new CompanyDaoImpl();
        Company company = companyDao.findByName("ОАО \"НЛМК\"");
        description.setText(company.getDescription());
    }

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
