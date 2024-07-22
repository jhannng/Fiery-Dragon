package org.example.fierydragon;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;

public class GameMainMenuController implements Subscriber {
    private Game fieryDragon;
    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    private ImageView chitCard1, chitCard2, chitCard3, chitCard4, chitCard5, chitCard6, chitCard7, chitCard8, chitCard9, chitCard10, chitCard11, chitCard12, chitCard13, chitCard14, chitCard15, chitCard16;

    @FXML
    private ImageView square1, square2, square3, square4, square5, square6, square7, square8, square9, square10, square11, square12, square13, square14, square15, square16, square17, square18, square19, square20, square21, square22, square23, square24;
    private ImageView[] defaultSquares;

    @FXML
    private ImageView token1, token2, token3, token4, token5, token6, token7, token8, token9, token10, token11, token12, token13, token14, token15, token16, token17, token18, token19, token20, token21, token22, token23, token24;
    private ImageView[] defaultTokens;

    @FXML
    private ImageView caveToken1, caveToken2, caveToken3, caveToken4;
    private ImageView[] defaultCaveTokens;

    @FXML
    private ImageView cave1, cave2, cave3, cave4;
    private ImageView[] defaultCaves;

    private boolean mockGameCTState = false;
    private int previousSquareIndex = -1;

    @FXML
    private void initialize() {
        ArrayList<String> playerName = new ArrayList<>();
        playerName.add("Alex");
        playerName.add("Betty");
        playerName.add("Chris");
        playerName.add("Daniel");

        this.fieryDragon = new Game(4, playerName, this);

        this.defaultCaves = new ImageView[] {cave1, cave2, cave4, cave3};
        this.defaultCaveTokens = new ImageView[] {caveToken1, caveToken2, caveToken4, caveToken3};
        this.defaultTokens = new ImageView[] {token1, token2, token3, token4, token5, token6, token7, token8, token9, token10, token11, token12, token13, token14, token15, token16, token17, token18, token19, token20, token21, token22, token23, token24};
        this.defaultSquares = new ImageView[] {square1, square2, square3, square4, square5, square6, square7, square8, square9, square10, square11, square12, square13, square14, square15, square16, square17, square18, square19, square20, square21, square22, square23, square24};

        this.setUpGameBoard();
    }

    /**
     * This method will set up the game board user interface
     */
    @FXML
    private void setUpGameBoard() {
        ArrayList<VolcanoCard> gameBoard = this.fieryDragon.getGameBoard().getGameBoard();
        int squareIndex = 0;
        int caveIndex = 0;

        for (int i = 0; i < gameBoard.size(); i ++) {
            for (int j = 0; j < gameBoard.get(i).getVolcanoCard().size(); j ++) {
                Square currentSquare = gameBoard.get(i).getVolcanoCard().get(j);

                Image squareImage = new Image(GameMainMenuController.class.getResource("/img/" + String.valueOf(currentSquare.getAnimalType().getAnimal()) + ".png").toString());
                this.defaultSquares[squareIndex].setImage(squareImage);

                if (currentSquare.isHasCave()) {
                    Image caveImage = new Image(GameMainMenuController.class.getResource("/img/" + String.valueOf(currentSquare.getCave().getAnimalType()) + ".png").toString());
                    this.defaultCaves[caveIndex].setImage(caveImage);
                    Image caveToken = new Image(GameMainMenuController.class.getResource("/img/" + String.format("Token_-_%d.png", (caveIndex + 1))).toString());
                    this.defaultCaveTokens[caveIndex].setImage(caveToken);

                    caveIndex ++;
                }

                squareIndex ++;
            }
        }
    }

    /**
     * This method will update the user interface once each player execute move
     *
     * @param gameBoard
     * @param currentPlayer
     */
    @Override
    public void update(GameBoard gameBoard, Player currentPlayer) {
        int squareIndex = 0;
        boolean squareFlag = false;

        int caveIndex = 0;
        boolean caveFlag = false;

        Square currentSquare;

        for (int i = 0; i < gameBoard.getGameBoard().size(); i ++) {
            for (int j = 0; j < gameBoard.getGameBoard().get(i).getVolcanoCard().size(); j ++) {
                currentSquare = gameBoard.getGameBoard().get(i).getVolcanoCard().get(j);

                if (!squareFlag) {
                    if (currentSquare.getToken() != null && currentSquare.getToken().getTokenID() == currentPlayer.getPlayerID()) {
                        squareFlag = true;
                    } else {
                        squareIndex++;
                    }
                }

                if (currentSquare.isHasCave()) {
                    if (!caveFlag) {
                        if (currentSquare.getCave().getCaveID() == currentPlayer.getPlayerID()) {
                            caveFlag = true;
                        } else {
                            caveIndex++;
                        }
                    }
                }
            }
        }

        this.updateCaveTokenUI(caveIndex);
        this.updateSquareUI(squareIndex, caveIndex, currentPlayer);
        this.checkWinnerOfTheGame(currentPlayer);
    }

    /**
     * This method will update the user interface of Square
     *
     * @param squareIndex
     * @param caveIndex
     * @param currentPlayer
     */
    @FXML
    private void updateSquareUI(int squareIndex, int caveIndex, Player currentPlayer) {
        if (currentPlayer.getToken().getTokenPosition() < 25) {
            Image tokenImage = new Image(GameMainMenuController.class.getResource("/img/" + String.format("Token_-_%d.png", (caveIndex + 1))).toString());
            this.defaultTokens[squareIndex].setImage(tokenImage);
        }

        if (this.previousSquareIndex > 0) {
            this.defaultTokens[this.previousSquareIndex].setVisible(false);
        }

        this.previousSquareIndex = squareIndex;
    }

    /**
     * This method will update the user interface of caveToken
     *
     * @param index
     */
    @FXML
    private void updateCaveTokenUI(int index) {
        if (!this.mockGameCTState) {
            this.defaultCaveTokens[index].setVisible(false);
            this.mockGameCTState = true;
        } else {
            this.defaultCaveTokens[index].setVisible(true);
        }
    }

    /**
     * This method will check the winner in the game
     *
     * @param currentPlayer
     */
    private void checkWinnerOfTheGame(Player currentPlayer) {
        if (currentPlayer.getStatus()) {
            this.switchScene();
        }
    }

    /**
     * This method will switch to wining scene
     */
    private void switchScene() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("WiningPage.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) square1.getScene().getWindow();

            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2), e -> {
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }));

            timeline.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void setScenarioButton() {
        this.fieryDragon.runMockGame();
    }

    @FXML
    public void runSimulatorButton() {
        this.fieryDragon.runSimulator();
    }
}
