package com.erpsystem;

import java.io.IOException;

import com.erpsystem.controller.MainController;
import com.erpsystem.controller.SceneNavigator;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Created on 14.11.2014.
 */
public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        stage.setTitle("ERP System");
        Pane mainPane = loadMainPane();
        stage.setScene(createScene(mainPane));
        stage.show();
    }

    private Pane loadMainPane() throws IOException {
        FXMLLoader loader = new FXMLLoader();

        Pane mainPane = loader.load(getClass().getResourceAsStream(SceneNavigator.MAIN));
        MainController mainController = loader.getController();
        SceneNavigator.setMainController(mainController);

        SceneNavigator.loadScene(SceneNavigator.START_SCENE);

        return mainPane;
    }

    private Scene createScene(Pane mainPane) {
        return new Scene(mainPane);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
