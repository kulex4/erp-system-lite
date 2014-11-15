package com.erpsystem;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Created on 14.11.2014.
 */
public class MainApp extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("ERP System");

        showCompanyOverview();
    }

    public void showCompanyOverview() {
        try {
            BorderPane companyOverview = FXMLLoader.load(getClass().getResource("/CompanyOverview.fxml"));

            Scene scene = new Scene(companyOverview);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
