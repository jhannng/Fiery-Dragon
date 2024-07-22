package org.fierydragon.fierydragon.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.fierydragon.fierydragon.GameUI;

import java.io.IOException;

/**
 * A controller class for the player name scene
 * Created by:
 * @author Teoh You Xian
 */
public class PlayerNameController {
    @FXML
    private TextField player1;
    @FXML
    private TextField player2;
    @FXML
    private TextField player3;
    @FXML
    private TextField player4;
    @FXML
    private ImageView player1Icon;
    @FXML
    private ImageView player2Icon;
    @FXML
    private ImageView player3Icon;
    @FXML
    private ImageView player4Icon;

    private Stage stage;
    private Scene scene;
    private Parent root;

    private int numOfPlayers;
    private TextField[] players;
    private ImageView[] playersIcon;
    private String[] names;
    public ImageView backgroundImage;

    @FXML
    public void initialize(int numOfPlayers){

        players = new TextField[]{player1, player2, player3, player4};
        playersIcon = new ImageView[]{player1Icon, player2Icon, player3Icon, player4Icon};

        for (int i = 0; i < numOfPlayers; i++){
            players[i].setVisible(true);
            playersIcon[i].setVisible(true);
            playersIcon[i].setImage(new Image(GameController.class.getResource("/img/" + GameUI.theme + "/Player" + (i+1) + ".png").toString()));
        }
        this.numOfPlayers = numOfPlayers;
    }

    /**
     * Event handlers for confirming the player name
     *
     * @param event The mouse event
     * @throws IOException If the game scene cannot be loaded
     */
    public void confirm(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/fierydragon/fierydragon/GameScene.fxml"));
        root = loader.load();

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        names = new String[]{"Player 1", "Player 2", "Player 3", "Player 4"};
        for (int i = 0; i < numOfPlayers; i ++){
            if (!players[i].getText().equals("")) {
                names[i] = players[i].getText();
            }
        }

        GameController controller = loader.getController();
        controller.initialise(this.numOfPlayers, names);
    }

    /**
     * Event handler for redirect to last page
     *
     * @param event The action event
     * @throws IOException If the select player scene cannot be loaded
     */
    @FXML
    public void backToLastPage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/org/fierydragon/fierydragon/SelectPlayerScene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
