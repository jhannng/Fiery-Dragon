package org.fierydragon.fierydragon.controller;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.fierydragon.fierydragon.*;
import org.fierydragon.fierydragon.action.FlipChitCardAction;
import org.fierydragon.fierydragon.action.SkipTurnAction;
import org.fierydragon.fierydragon.chitcard.ChitCard;
import org.fierydragon.fierydragon.subscriber.ChitCardSubscriber;
import org.fierydragon.fierydragon.subscriber.MovementSubscriber;
import org.fierydragon.fierydragon.subscriber.Subscriber;
import org.fierydragon.fierydragon.subscriber.SubscriberType;
import org.fierydragon.fierydragon.tile.Tile;
import org.fierydragon.fierydragon.utils.LoadGame;
import org.fierydragon.fierydragon.utils.SaveGame;

import java.awt.event.ActionEvent;
import java.io.IOException;
import static java.lang.Math.abs;

/**
 * A controller class for the main game.
 * Created by:
 *  @author Teoh You Xian, Lim Jian Tao, Hang Jui Kai, Lee Yi Mei
 */
public class GameController {
    @FXML
    private ImageView
            squareAnimal01, squareAnimal02, squareAnimal03, squareAnimal04, squareAnimal05, squareAnimal06, squareAnimal07, squareAnimal08, squareAnimal09, squareAnimal10, squareAnimal11, squareAnimal12, squareAnimal13, squareAnimal14, squareAnimal15, squareAnimal16, squareAnimal17, squareAnimal18, squareAnimal19, squareAnimal20, squareAnimal21, squareAnimal22, squareAnimal23, squareAnimal24,
            squareToken01, squareToken02, squareToken03, squareToken04, squareToken05, squareToken06, squareToken07, squareToken08, squareToken09, squareToken10, squareToken11, squareToken12, squareToken13, squareToken14, squareToken15, squareToken16, squareToken17, squareToken18, squareToken19, squareToken20, squareToken21, squareToken22, squareToken23, squareToken24,
            chitCard01, chitCard02, chitCard03, chitCard04, chitCard05, chitCard06, chitCard07, chitCard08, chitCard09, chitCard10, chitCard11, chitCard12, chitCard13, chitCard14, chitCard15, chitCard16, chitCard17, chitCard18,
            caveAnimal01, caveAnimal02, caveAnimal03, caveAnimal04,
            caveToken01, caveToken02, caveToken03, caveToken04;
    @FXML
    private Label timeLeft;
    @FXML
    private Label playerID;
    @FXML
    private Button skipButton;
    @FXML
    private ImageView flipAgain;
    @FXML
    private ImageView tokenHolder01, tokenHolder02, tokenHolder03, tokenHolder04;
    @FXML
    private Label playerNameHolder01, playerNameHolder02, playerNameHolder03, playerNameHolder04;
    @FXML
    private ImageView playerStatusBar;
    @FXML
    private Label playerMoveName01, playerMoveName02, playerMoveName03, playerMoveName04;
    @FXML
    private Label playerMoveRemain01, playerMoveRemain02, playerMoveRemain03, playerMoveRemain04;
    @FXML
    private ImageView timerInfo;
    @FXML
    private ImageView homeView;
    @FXML
    private ImageView restartView;
    @FXML
   private ImageView instructionView;
    @FXML
    private ImageView playerInfo;
    @FXML
    private ImageView roundInfo;
    private Timeline gameTimeline;
    private Timeline timer;
    private int time;
    private Game game;
    private GameUI gameUI;
    private Parent root;
    private Stage stage;
    private Scene scene;
    public ImageView backgroundImage;


    /**
     * Constructor
     */
    public GameController() {
        this.time = 12;
    }

    /**
     * This method will initialise the necessary variable for the game and running the game
     */
    public void initialise() {

        // Load the game
        LoadGame loadGame = new LoadGame();
        loadGame.loadGame();
        backgroundImage.setImage(new Image(GameController.class.getResource("/img/" + GameUI.theme + "/GameBoard.png").toString()));

        // Initialise the scene and render it
        this.game = new Game(loadGame.getPlayers(), loadGame.getGameBoard());
        this.gameUI = new GameUI(
                new ImageView[] {squareAnimal01, squareAnimal02, squareAnimal03, squareAnimal04, squareAnimal05, squareAnimal06, squareAnimal07, squareAnimal08, squareAnimal09, squareAnimal10, squareAnimal11, squareAnimal12, squareAnimal13, squareAnimal14, squareAnimal15, squareAnimal16, squareAnimal17, squareAnimal18, squareAnimal19, squareAnimal20, squareAnimal21, squareAnimal22, squareAnimal23, squareAnimal24},
                new ImageView[] {squareToken01, squareToken02, squareToken03, squareToken04, squareToken05, squareToken06, squareToken07, squareToken08, squareToken09, squareToken10, squareToken11, squareToken12, squareToken13, squareToken14, squareToken15, squareToken16, squareToken17, squareToken18, squareToken19, squareToken20, squareToken21, squareToken22, squareToken23, squareToken24},
                new ImageView[] {chitCard01, chitCard02, chitCard03, chitCard04, chitCard05, chitCard06, chitCard07, chitCard08, chitCard09, chitCard10, chitCard11, chitCard12, chitCard13, chitCard14, chitCard15, chitCard16, chitCard17, chitCard18},
                new ImageView[] {caveAnimal01, caveAnimal02, caveAnimal03, caveAnimal04},
                new ImageView[] {caveToken01, caveToken02, caveToken03, caveToken04},
                new ImageView[] {tokenHolder01, tokenHolder02, tokenHolder03, tokenHolder04},
                new Label[] {playerNameHolder01, playerNameHolder02, playerNameHolder03, playerNameHolder04},
                this.playerStatusBar,
                new Label[] {playerMoveName01, playerMoveName02, playerMoveName03, playerMoveName04},
                new Label[] {playerMoveRemain01, playerMoveRemain02, playerMoveRemain03, playerMoveRemain04},
                this.timerInfo,
                this.playerInfo,
                this.roundInfo,
                this.homeView,
                this.restartView,
                this.instructionView,
                this.skipButton,
                this.flipAgain,
                this.timeLeft,
                this.playerID
        );
        this.gameUI.initialRenderBoard(this.game.getGameBoard().getVolcanoCards());
        this.gameUI.initialRenderPlayers(this.game.getPlayers());
        this.gameUI.initialRenderCards();
        this.gameUI.initialRenderPlayerInfo(this.game.getPlayers());
        this.gameUI.initialRenderElements();
        this.gameUI.initialRenderPlayerMoveInfo(this.game.getPlayers());
        this.gameUI.setSkipButtonInvisible();

        TurnManager turnManager = TurnManager.getInstance();
        turnManager.setPlayers(this.game.getPlayers());
        for (int i = 1; i < loadGame.getCurrPlayerTurn(); i++) {
            turnManager.nextTurn();
        }
        this.gameUI.setPlayerName(turnManager.getCurrentPlayer().getName());

        this.run();
    }

    /**
     * This method will initialise the necessary variable for the game and running the game
     *
     * @param amountOfPlayers The amount of player that will play the game
     */
    public void initialise(int amountOfPlayers, String[] playersName) {

        // Initialise the scene and render it
        backgroundImage.setImage(new Image(GameController.class.getResource("/img/" + GameUI.theme + "/GameBoard.png").toString()));
        this.game = new Game();
        this.gameUI = new GameUI(
                new ImageView[] {squareAnimal01, squareAnimal02, squareAnimal03, squareAnimal04, squareAnimal05, squareAnimal06, squareAnimal07, squareAnimal08, squareAnimal09, squareAnimal10, squareAnimal11, squareAnimal12, squareAnimal13, squareAnimal14, squareAnimal15, squareAnimal16, squareAnimal17, squareAnimal18, squareAnimal19, squareAnimal20, squareAnimal21, squareAnimal22, squareAnimal23, squareAnimal24},
                new ImageView[] {squareToken01, squareToken02, squareToken03, squareToken04, squareToken05, squareToken06, squareToken07, squareToken08, squareToken09, squareToken10, squareToken11, squareToken12, squareToken13, squareToken14, squareToken15, squareToken16, squareToken17, squareToken18, squareToken19, squareToken20, squareToken21, squareToken22, squareToken23, squareToken24},
                new ImageView[] {chitCard01, chitCard02, chitCard03, chitCard04, chitCard05, chitCard06, chitCard07, chitCard08, chitCard09, chitCard10, chitCard11, chitCard12, chitCard13, chitCard14, chitCard15, chitCard16, chitCard17, chitCard18},
                new ImageView[] {caveAnimal01, caveAnimal02, caveAnimal03, caveAnimal04},
                new ImageView[] {caveToken01, caveToken02, caveToken03, caveToken04},
                new ImageView[] {tokenHolder01, tokenHolder02, tokenHolder03, tokenHolder04},
                new Label[] {playerNameHolder01, playerNameHolder02, playerNameHolder03, playerNameHolder04},
                this.playerStatusBar,
                new Label[] {playerMoveName01, playerMoveName02, playerMoveName03, playerMoveName04},
                new Label[] {playerMoveRemain01, playerMoveRemain02, playerMoveRemain03, playerMoveRemain04},
                this.timerInfo,
                this.playerInfo,
                this.roundInfo,
                this.homeView,
                this.restartView,
                this.instructionView,
                this.skipButton,
                this.flipAgain,
                this.timeLeft,
                this.playerID
        );
        this.gameUI.initialRenderBoard(this.game.getGameBoard().getVolcanoCards());
        this.gameUI.initialRenderCards();
        this.gameUI.setSkipButtonInvisible();
        this.game.createPlayers(amountOfPlayers, playersName);
        this.gameUI.initialRenderPlayers(this.game.getPlayers());
        this.gameUI.initialRenderPlayerInfo(this.game.getPlayers());
        this.gameUI.initialRenderElements();
        this.gameUI.initialRenderPlayerMoveInfo(this.game.getPlayers());
        TurnManager turnManager = TurnManager.getInstance();
        turnManager.setPlayers(this.game.getPlayers());
        turnManager.reset();
        this.gameUI.setPlayerName(turnManager.getCurrentPlayer().getName());
        this.run();
    }

    /**
     * This method will run the main game loop logic
     */
    public void run() {
        TurnManager turnManager = TurnManager.getInstance();
        // Assign an onMouseClicked listener for each chit card
        for (int i = 0; i < this.game.getGameBoard().getChitCards().size(); i++) {
            ImageView chitCard = this.gameUI.getChitCardImageView(i);
            GameBoard gameBoard = this.game.getGameBoard();

            // To retrieve the animal name and quantity of chit card
            int quantity = gameBoard.getChitCards().get(i).getAmountOfAnimal();
            String animal = gameBoard.getChitCards().get(i).getAnimal().getAnimalType().name();
            Image chitCardFront = new Image(getClass().getResourceAsStream(String.format("/img/%s/%s_%d.png", GameUI.theme, animal, abs(quantity))));

            // To call onClick method for flipping card
            ChitCard chitCardObject = gameBoard.getChitCards().get(i);
            chitCardOnClick(chitCard, chitCardFront, chitCardObject);
        }

        // Display timer in the game
        this.timer = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            if (this.time > 0) {
                this.gameUI.setTimer(String.valueOf(this.time));
                this.time--;
            } else {
                this.gameUI.setTimer("Times Up!");
                this.time = 12;
            }
        }));

        this.timer.setCycleCount(Animation.INDEFINITE);
        this.timer.play();

        // The timeline for each turn
        this.gameTimeline = new Timeline(
                new KeyFrame(Duration.seconds(13), event -> {
                    this.gameUI.setPlayerName(turnManager.getCurrentPlayer().getName());
                    gameUI.setSkipButtonInvisible();
                    SkipTurnAction skipAction = new SkipTurnAction();
                    skipAction.execute(TurnManager.getInstance().getCurrentPlayer(), null);
                    Image chitCardImage = new Image(getClass().getResourceAsStream(String.format("/img/" + GameUI.theme + "/ChitCard.png")));
                    this.gameUI.closeChitCard(chitCardImage);
                    this.gameUI.unsubscribe(SubscriberType.CHIT_CARD_SUBSCRIBER);
                    this.gameUI.setPlayerName(turnManager.getCurrentPlayer().getName());
                })
        );
        this.gameTimeline.setCycleCount(Timeline.INDEFINITE);
        this.gameTimeline.play();
    }

    /**
     * This method will handle the logic when a chit card is clicked
     *
     * @param currentChitCard The image view that will hold the chit card
     * @param chitCardFront The front Image of the chit card
     * @param chitCardObject The instance of the chit card that is clicked
     */
    public void chitCardOnClick(ImageView currentChitCard, Image chitCardFront, ChitCard chitCardObject) {
        ChitCardSubscriber chitCardSubscriber = new ChitCardSubscriber();

        currentChitCard.setOnMouseClicked(event -> {
            // Change the back of chit card to the front
            this.gameUI.subscribe(SubscriberType.CHIT_CARD_SUBSCRIBER, chitCardSubscriber);
            this.gameUI.openChitCard(currentChitCard, chitCardFront);

            FlipChitCardAction flipAction = new FlipChitCardAction();
            if (!chitCardObject.getFlipped()) {
                TurnManager turnManager = TurnManager.getInstance();

                int steps = flipAction.execute(turnManager.getCurrentPlayer(), chitCardObject);
                if (steps > (26 - turnManager.getCurrentPlayer().getPlayerToken().getTotalDisplacement())) {
                    steps = 0;
                }

                boolean matched = steps != 0;
                boolean enterCave = chitCardObject.getAnimal().visit(turnManager.getCurrentPlayer().getPlayerToken().getTile().getAnimal()) == 2;

                TurnManager.getInstance().addFlippedChitCard(chitCardObject);

                // Create a PauseTransition that lasts for 3 seconds
                PauseTransition pause = new PauseTransition(Duration.seconds(1));
                this.timer.stop();
                this.gameTimeline.stop();
                int finalSteps = steps;
                pause.setOnFinished(e -> {
                    if (!matched) {
                        gameUI.setSkipButtonInvisible();
                        SkipTurnAction skipAction = new SkipTurnAction();
                        skipAction.execute(TurnManager.getInstance().getCurrentPlayer(), chitCardObject);
                        Image chitCardImage = new Image(getClass().getResourceAsStream(String.format("/img/" + GameUI.theme + "/ChitCard.png")));
                        this.gameUI.closeChitCard(chitCardImage);
                        this.gameUI.unsubscribe(SubscriberType.CHIT_CARD_SUBSCRIBER);
                        this.gameUI.setPlayerName(turnManager.getCurrentPlayer().getName());
                    } else {
                        gameUI.setSkipButtonVisible();
                        Tile lastSquare = turnManager.getCurrentPlayer().getPlayerToken().getTile();

                        // Move the token forward and backward in volcano
                        for (int i = 0; i < abs(finalSteps); i++) {
                            Tile currentTile = turnManager.getCurrentPlayer().getPlayerToken().getTile();

                            if (finalSteps > 0) {
                                currentTile.moveTokenForward();
                            }
                            else {
                                currentTile.moveTokenBackward(enterCave);
                            }
                        }

                        Subscriber movementSubscriber = new MovementSubscriber();
                        this.gameUI.subscribe(SubscriberType.MOVEMENT_SUBSCRIBER, movementSubscriber);
                        this.gameUI.moveToken(turnManager, lastSquare);
                        this.gameUI.unsubscribe(SubscriberType.MOVEMENT_SUBSCRIBER);

                        for (Player currentPlayer: turnManager.getAllPlayers()) {
                            currentPlayer.getPlayerToken().getTile().setToken(currentPlayer.getPlayerToken());
                        }

                        if (turnManager.getCurrentPlayer().getPlayerToken().getTotalDisplacement() == 26){
                            // Stop all the timeline
                            timer.stop();
                            timer.getKeyFrames().clear();
                            gameTimeline.stop();
                            gameTimeline.getKeyFrames().clear();

                            try {
                                FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/fierydragon/fierydragon/WinningScene.fxml"));
                                this.root = loader.load();

                                WinController winController = loader.getController();
                                winController.initParameters(TurnManager.getInstance().getCurrentPlayer(), TurnManager.getInstance().getAllPlayers());

                                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                                scene = new Scene(root);
                                stage.setScene(scene);
                                stage.show();
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }

                    this.time = 12;
                    this.timer.play();
                    this.gameTimeline.play();
                });

                // Start the pause transition
                pause.play();
            }
        });
    }

    /**
     * This method will handle the logic when the skip button is clicked
     */
    @FXML
    public void skipTurn() throws IOException{
        PauseTransition pause = new PauseTransition(Duration.seconds(1)); // TODO: Changed to 1 for faster debugging, change back later
        this.timer.stop();
        this.gameTimeline.stop();
        pause.setOnFinished(e -> {
            SkipTurnAction skipAction = new SkipTurnAction();
            TurnManager turnManager = TurnManager.getInstance();
            skipAction.execute(turnManager.getCurrentPlayer(), null);
            this.playerID.setText(String.format("%d", turnManager.getTurn()));
            Image chitCardImage = new Image(getClass().getResourceAsStream(String.format("/img/" + GameUI.theme + "/ChitCard.png")));
            this.gameUI.closeChitCard(chitCardImage);
            this.gameUI.setSkipButtonInvisible();
            this.time = 12;
            this.timer.play();
            this.gameTimeline.play();
            this.gameUI.setPlayerName(turnManager.getCurrentPlayer().getName());
        });

        // Start the pause transition
        pause.play();
    }

    /**
     * This method will handle the logic when home button is clicked
     *
     * @param mouseEvent The click event
     */
    public void homeButtonOnClick(MouseEvent mouseEvent) throws IOException {
        try {
            // Stop all the timeline
            timer.stop();
            timer.getKeyFrames().clear();
            gameTimeline.stop();
            gameTimeline.getKeyFrames().clear();

            // Save game
            SaveGame saveGame = new SaveGame();
            saveGame.saveGame(this.game.getGameBoard().getVolcanoCards(), this.game.getPlayers(), this.game.getGameBoard().getChitCards());

            // Load the home page FXML file
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/fierydragon/fierydragon/HomeScene.fxml"));
            Parent homePage = fxmlLoader.load();

            // Get the current stage (window) from the event that was passed in
            Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();

            // Create a new scene with the root of the home page
            Scene scene = new Scene(homePage);

            // Set the scene for the stage and show it
            stage.setScene(scene);
            stage.show();
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method will handle the logic when the game is restarting
     */
    public void restartButtonOnClick(MouseEvent mouseEvent) throws IOException {
        try {
            // Stop all the timeline
            timer.stop();
            timer.getKeyFrames().clear();
            gameTimeline.stop();
            gameTimeline.getKeyFrames().clear();

            // Load the home page FXML file
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/fierydragon/fierydragon/SelectThemeScene.fxml"));
            Parent homePage = fxmlLoader.load();

            // Get the current stage (window) from the event that was passed in
            Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();

            // Create a new scene with the root of the home page
            Scene scene = new Scene(homePage);

            // Set the scene for the stage and show it
            stage.setScene(scene);
            stage.show();
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }
}