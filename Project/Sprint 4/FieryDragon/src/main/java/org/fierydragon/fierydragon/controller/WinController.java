package org.fierydragon.fierydragon.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.fierydragon.fierydragon.GameUI;
import org.fierydragon.fierydragon.Player;
import java.io.IOException;
import java.util.ArrayList;

/**
 * A controller class for the wining game.
 * Created by:
 *  @author Lee Yi Mei
 */
public class WinController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label winningPlayerHolder;
    @FXML
    private Label player1, player2, player3, player4;
    @FXML
    private Label remainPlayer1, remainPlayer2, remainPlayer3, remainPlayer4;
    private Label[] playersLabels;
    private Label[] remainPlayers;

    /**
     * The player that win the game
     */
    private Player winPlayer;
    private ArrayList<Player> gamePlayers;
    public ImageView backgroundImage;

    public void initialize() {
        backgroundImage.setImage(new Image(GameController.class.getResource("/img/" + GameUI.theme + "/WinningPageBackground.png").toString()));
    }

    /**
     * Init parameter method that get parameter from other controller class
     *
     * @param player The player that won the game
     * @param players All the player in the game
     */
    public void initParameters(Player player, ArrayList<Player> players) {
        playersLabels = new Label[] {player1, player2, player3, player4};
        remainPlayers = new Label[] {remainPlayer1, remainPlayer2, remainPlayer3, remainPlayer4};
        this.winPlayer = player;
        this.gamePlayers = players;

        this.initializeWinDisplay();
    }

    /**
     * This method initialize the win display method
     */
    private void initializeWinDisplay() {
        winningPlayerHolder.setText(winPlayer.getName());
        for (int i = 0; i < gamePlayers.size(); i++) {
            this.playersLabels[i].setText(gamePlayers.get(i).getName());
            this.remainPlayers[i].setText(String.valueOf(26 - gamePlayers.get(i).getPlayerToken().getTotalDisplacement()));
        }
    }

    /**
     * This method handle the logic when home button is clicked
     *
     * @param event The click event
     */
    public void homeButtonOnClick(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/org/fierydragon/fierydragon/HomeScene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * This method handle the logic when home button is clicked
     * @param event The click event
     */
    public void restartButtonOnClick(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/org/fierydragon/fierydragon/SelectPlayerScene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}

