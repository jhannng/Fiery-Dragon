package org.fierydragon.fierydragon.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * A controller class for the main game.
 * Created by:
 *  @author Lee Yi Mei
 */
public class HomeController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    /**
     * Event handler for clicking the play button
     * @param event The action event
     * @throws IOException If the select player scene cannot be loaded
     */
    public void onClickPlayButton(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/org/fierydragon/fierydragon/SelectThemeScene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void loadButtonOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/fierydragon/fierydragon/GameScene.fxml"));
        root = loader.load();

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        GameController controller = loader.getController();
        controller.initialise();
    }
}
