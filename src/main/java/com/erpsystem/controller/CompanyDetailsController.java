package com.erpsystem.controller;

import com.erpsystem.dao.CompanyDao;
import com.erpsystem.dao.CompanyDaoImpl;
import com.erpsystem.model.Company;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javax.swing.text.html.Option;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * Created on 07.12.2014.
 */
public class CompanyDetailsController implements Initializable {

    private CompanyDao companyDao;
    private Company currentCompany;
    private String saveState;
    private String modifyState;

    @FXML
    private Button backButton;

    @FXML
    private Button modificationButton;

    @FXML
    private Label companyNameLabel;

    @FXML
    private TextField numberOfManagersField;

    @FXML
    private TextField numberOfQualifiedManagersField;

    @FXML
    private TextField numberOfNotQualifiedManagersField;

    @FXML
    private TextField trainingCostField;

    public CompanyDetailsController() {
        companyDao = new CompanyDaoImpl();
        currentCompany = companyDao.findByName("ОАО \"НЛМК\"");
        saveState = "Сохранить";
        modifyState = "Изменить";
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initCompanyFields(currentCompany);
    }

    private void initCompanyFields(Company company) {
        companyNameLabel.setText(company.getName());
        numberOfManagersField.setText(String.valueOf(company.getNumberOfManagers()));
        numberOfQualifiedManagersField.setText(String.valueOf(company.getNumberOfQualifiedManagers()));
        numberOfNotQualifiedManagersField.setText(String.valueOf(company.getNumberOfNotQualifiedManagers()));
        trainingCostField.setText(String.valueOf(company.getTrainingCost()));
    }

    @FXML
    private void backButtonClick(ActionEvent event) {
        SceneNavigator.loadScene(SceneNavigator.START_SCENE);
    }

    @FXML
    private void modificationButtonClick(ActionEvent event) {
        if(modificationButton.getText().equals(modifyState)) {
            modificationButton.setText(saveState);
            numberOfManagersField.setDisable(false);
            numberOfQualifiedManagersField.setDisable(false);
            numberOfNotQualifiedManagersField.setDisable(false);
            trainingCostField.setDisable(false);
        } else {
            Company company = parseDataFromFields();
            companyDao.update(company);
            initCompanyFields(company);
            currentCompany = company;

            modificationButton.setText(modifyState);
            numberOfManagersField.setDisable(true);
            numberOfQualifiedManagersField.setDisable(true);
            numberOfNotQualifiedManagersField.setDisable(true);
            trainingCostField.setDisable(true);
        }
    }

    private Company parseDataFromFields() {
        Company company = currentCompany;

        company.setNumberOfManagers(handleNumberOfManagers());
        company.setNumberOfQualifiedManagers(handleNumberOfQualifiedManagers());
        company.setNumberOfNotQualifiedManagers(handleNumberOfNotQualifiedManagers());
        company.setTrainingCost(handleTrainingCost());

        return company;
    }

    private int handleNumberOfManagers() {
        if(isInteger(numberOfManagersField.getText())) {
            return Integer.parseInt(numberOfManagersField.getText());
        } else {
            return currentCompany.getNumberOfManagers();
        }
    }

    private int handleNumberOfQualifiedManagers() {
        if(isInteger(numberOfQualifiedManagersField.getText())) {
            return Integer.parseInt(numberOfQualifiedManagersField.getText());
        } else {
            return currentCompany.getNumberOfQualifiedManagers();
        }
    }

    private int handleNumberOfNotQualifiedManagers() {
        if(isInteger(numberOfNotQualifiedManagersField.getText())) {
            return Integer.parseInt(numberOfNotQualifiedManagersField.getText());
        } else {
            return currentCompany.getNumberOfNotQualifiedManagers();
        }
    }

    private double handleTrainingCost() {
        if(isDouble(trainingCostField.getText())) {
            return Double.parseDouble(trainingCostField.getText());
        } else {
            return currentCompany.getTrainingCost();
        }
    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static boolean isDouble(String s) {
        try {
            Double.parseDouble(s);
        } catch(NumberFormatException e) {
            return false;
        }
        return true;
    }
}
