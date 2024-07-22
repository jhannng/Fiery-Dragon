package org.fierydragon.fierydragon.controller;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * A controller class for the select player scene
 * Created by:
 * @author Lim Jian Tao
 */
public class SelectPlayerController {
    /**
     * Number of player selected
     */
    private int numOfPlayer;

    private Stage stage;
    private Scene scene;
    private Parent root;

    /**
     * Event handlers for clicking the 2 player button
     * @param event The mouse event
     * @throws IOException If the game scene cannot be loaded
     */
    public void onClick2Players(MouseEvent event) throws IOException {
        numOfPlayer = 2;
        switchSceneAndRunGame(event, numOfPlayer);
    }

    /**
     * Event handlers for clicking the 3 player button
     * @param event The mouse event
     * @throws IOException If the game scene cannot be loaded
     */
    public void onClick3Players(MouseEvent event) throws IOException {
        numOfPlayer = 3;
        switchSceneAndRunGame(event, numOfPlayer);
    }

    /**
     * Event handlers for clicking the 4 player button
     * @param event The mouse event
     * @throws IOException If the game scene cannot be loaded
     */
    public void onClick4Players(MouseEvent event) throws IOException {
        numOfPlayer = 4;
        switchSceneAndRunGame(event, numOfPlayer);
    }

    /**
     * Switch to the game scene and execute the game
     * @param event The mouse event
     * @param numOfPlayer The number players in this game
     * @throws IOException If the game scene cannot be loaded
     */
    private void switchSceneAndRunGame(MouseEvent event, int numOfPlayer) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/fierydragon/fierydragon/GameScene.fxml"));
        root = loader.load();

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        GameController controller = loader.getController();
        controller.initialize(numOfPlayer);
    }
}
