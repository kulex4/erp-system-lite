package com.erpsystem.controller;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;

/**
 * Created on 07.12.2014.
 */

public class MainController {

    @FXML
    private StackPane sceneHolder;

    public void setScene(Node node) {
        sceneHolder.getChildren().setAll(node);
    }

}