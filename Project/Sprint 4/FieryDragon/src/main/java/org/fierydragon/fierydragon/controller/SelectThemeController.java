package org.fierydragon.fierydragon.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.fierydragon.fierydragon.GameUI;
import org.fierydragon.fierydragon.utils.Theme;

import java.io.IOException;

/**
 * A controller class for the game theme.
 * Created by:
 *  @author Lee Yi Mei
 */
public class SelectThemeController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    /**
     * Event handler for clicking the play button
     *
     * @param event The action event
     * @throws IOException If the select player scene cannot be loaded
     */
    public void onClickTarzanButton(ActionEvent event) throws IOException {
        GameUI.theme = Theme.TARZAN;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/fierydragon/fierydragon/SelectPlayerScene.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Event handler for clicking the play button
     *
     * @param event The action event
     * @throws IOException If the select player scene cannot be loaded
     */
    public void onClickMermaidButton(ActionEvent event) throws IOException {
        GameUI.theme = Theme.MERMAID;
        
        root = FXMLLoader.load(getClass().getResource("/org/fierydragon/fierydragon/SelectPlayerScene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Event handler for redirect to last page
     *
     * @param event The action event
     * @throws IOException If the select player scene cannot be loaded
     */
    @FXML
    public void backToLastPage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/org/fierydragon/fierydragon/HomeScene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
