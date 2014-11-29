package com.erpsystem;

import java.io.IOException;

import com.erpsystem.controller.CompanyController;
import com.erpsystem.dao.CompanyDao;
import com.erpsystem.dao.CompanyDaoImpl;
import com.erpsystem.model.Company;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Created on 14.11.2014.
 */
public class MainApp extends Application {

    private Stage primaryStage;
    private ObservableList<Company> companyData = FXCollections.observableArrayList();

    public MainApp() {
        CompanyDao companyDao = new CompanyDaoImpl();
        companyData.addAll(companyDao.findAll());
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("ERP System");

        showCompanyOverview();
    }

    public void showCompanyOverview() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/CompanyOverview.fxml"));
            BorderPane companyOverview = loader.load();

            CompanyController controller = loader.getController();
            controller.setMainApp(this);

            Scene scene = new Scene(companyOverview);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ObservableList<Company> getCompanyData() {
        return companyData;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
