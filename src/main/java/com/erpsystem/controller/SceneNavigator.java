package com.erpsystem.controller;

import javafx.fxml.FXMLLoader;

import java.io.IOException;

/**
 * Created on 07.12.2014.
 */
public class SceneNavigator {

    public static final String MAIN = "/scenes/main-container.fxml";
    public static final String START_SCENE = "/scenes/start-page.fxml";

    public static final String SPECIALISTS_SCENE = "/scenes/specialist-page.fxml";
    public static final String CHOOSE_SPECIALIST_SCENE = "/scenes/start-page.fxml";
    public static final String ADD_SPECIALIST_SCENE = "/scenes/start-page.fxml";

    public static final String COMPANY_DETAILS_SCENE = "/scenes/company-details-page.fxml";
    public static final String ADD_COMPANY_DETAILS_SCENE = "/scenes/company-details-page.fxml";
    public static final String VIEW_COMPANY_DETAILS_SCENE = "/scenes/company-details-page.fxml";

    private static MainController mainController;

    public static void setMainController(MainController mainController) {
        SceneNavigator.mainController = mainController;
    }

    public static void loadScene(String fxml) {
        try {
            mainController.setScene(FXMLLoader.load(SceneNavigator.class.getResource(fxml)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}