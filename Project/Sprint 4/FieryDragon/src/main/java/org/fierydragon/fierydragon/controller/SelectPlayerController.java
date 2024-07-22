package org.fierydragon.fierydragon.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.fierydragon.fierydragon.GameUI;

import java.io.IOException;

/**
 * A controller class for the select player scene
 * Created by:
 * @author Teoh You Xian
 */
public class SelectPlayerController {
    /**
     * Number of player selected
     */
    private int numOfPlayer;

    private Stage stage;
    private Scene scene;
    private Parent root;
    public ImageView backgroundImage;

    @FXML
    public void initialize() {
        backgroundImage.setImage(new Image(GameController.class.getResource("/img/" + GameUI.theme + "/PlayerPage.png").toString()));
    }

    /**
     * Event handlers for clicking the two player button
     *
     * @param event The mouse event
     * @throws IOException If the game scene cannot be loaded
     */
    public void onClick2Players(MouseEvent event) throws IOException {
        numOfPlayer = 2;
        switchSceneAndRunGame(event, numOfPlayer);
    }

    /**
     * Event handlers for clicking the three player button
     *
     * @param event The mouse event
     * @throws IOException If the game scene cannot be loaded
     */
    public void onClick3Players(MouseEvent event) throws IOException {
        numOfPlayer = 3;
        switchSceneAndRunGame(event, numOfPlayer);
    }

    /**
     * Event handlers for clicking the four player button
     *
     * @param event The mouse event
     * @throws IOException If the game scene cannot be loaded
     */
    public void onClick4Players(MouseEvent event) throws IOException {
        numOfPlayer = 4;
        switchSceneAndRunGame(event, numOfPlayer);
    }

    /**
     * Switch to the game scene and execute the game
     *
     * @param event The mouse event
     * @param numOfPlayer The number players in this game
     * @throws IOException If the game scene cannot be loaded
     */
    private void switchSceneAndRunGame(MouseEvent event, int numOfPlayer) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/fierydragon/fierydragon/PlayerNameScene.fxml"));
        root = loader.load();

        PlayerNameController controller = loader.getController();
        controller.backgroundImage.setImage(new Image(GameController.class.getResource("/img/" + GameUI.theme + "/InputName.png").toString()));

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        controller.initialize(numOfPlayer);
    }

    /**
     * Event handler for redirect to last page
     *
     * @param event The action event
     * @throws IOException If the select player scene cannot be loaded
     */
    @FXML
    public void backToLastPage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/org/fierydragon/fierydragon/SelectThemeScene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
