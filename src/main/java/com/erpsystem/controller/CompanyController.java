package com.erpsystem.controller;

import com.erpsystem.MainApp;
import com.erpsystem.model.Company;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * Created on 14.11.2014.
 */
public class CompanyController {

    @FXML
    private TableView<Company> companyTable;
    @FXML
    private TableColumn<Company, String> companyNameColumn;

    @FXML
    private Label companyNameLabel;

    @FXML
    private Label companyDescriptionLabel;

    public CompanyController() {
    }

    @FXML
    private void initialize() {
        companyNameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());

        showCompanyDetails(null);
        companyTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showCompanyDetails(newValue));
    }

    public void setMainApp(MainApp mainApp) {
        //companyTable.setItems(mainApp.getCompanyData());
    }

    private void showCompanyDetails(Company company) {
        if (company != null) {
            companyNameLabel.setText(company.getName());
            companyDescriptionLabel.setText(company.getDescription());
        } else {
            companyNameLabel.setText("---");
            companyDescriptionLabel.setText("---");
        }
    }
}
