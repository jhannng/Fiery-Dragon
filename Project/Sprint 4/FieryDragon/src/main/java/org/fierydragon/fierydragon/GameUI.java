package org.fierydragon.fierydragon;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.fierydragon.fierydragon.controller.GameController;
import org.fierydragon.fierydragon.subscriber.Subscriber;
import org.fierydragon.fierydragon.subscriber.SubscriberType;
import org.fierydragon.fierydragon.tile.Square;
import org.fierydragon.fierydragon.tile.Tile;
import org.fierydragon.fierydragon.utils.Theme;
import org.fierydragon.fierydragon.volcano.Volcano;

import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.Math.abs;

/**
 * A class that used to initialise the user interface of the game
 * Created by:
 *  @author Lim Jian Tao, Lee Yi Mei
 */
public class GameUI {
    private ImageView[] squareAnimalImageViews;
    private ImageView[] squareTokenImageViews;
    private ImageView[] chitCardImageViews;
    private ImageView[] caveAnimalImageViews;
    private ImageView[] caveTokenImageViews;
    private ImageView[] playerHolderImages;
    private Label[] playerNameHolders;
    private ImageView playerStatusBar;
    private Label[] playerMoveNames;
    private Label[] playerMoveRemains;
    private HashMap<SubscriberType, ArrayList<Subscriber>> subscribers;
    private ImageView timerInfo;
    private ImageView playerInfo;
    private ImageView roundInfo;
    private ImageView homeView;
    private ImageView restartView;
    private ImageView instructionView;
    private Button skipButton;
    private ImageView flipAgain;
    private Label timer;
    private Label playerId;
    public static Theme theme;

    /**
     * Constructor
     *
     * @param squareAnimalImageViews A list of ImageView for the Square in the game
     * @param squareTokenImageViews A list of ImageView for the SquareToken in the game
     * @param chitCardImageViews A list of ImageView for the ChitCard in the game
     * @param caveAnimalImageViews A list of ImageView for the Animal of each Cave in the game
     * @param caveTokenImageViews A list of ImageView for the CaveToken in the game
     */
    public GameUI(ImageView[] squareAnimalImageViews, ImageView[] squareTokenImageViews, ImageView[] chitCardImageViews, ImageView[] caveAnimalImageViews, ImageView[] caveTokenImageViews,
                  ImageView[] playerHolderImages, Label[] playerNameHolders, ImageView playerStatusBar ,Label[] playerMoveNames, Label[] playerMoveRemains ,
                  ImageView timerInfo, ImageView playerInfo, ImageView roundInfo , ImageView homeView, ImageView restartView, ImageView instructionView,
                  Button skipButton, ImageView flipAgain, Label timer, Label playerID) {
        this.squareAnimalImageViews = squareAnimalImageViews;
        this.squareTokenImageViews = squareTokenImageViews;
        this.chitCardImageViews = chitCardImageViews;
        this.caveAnimalImageViews = caveAnimalImageViews;
        this.caveTokenImageViews = caveTokenImageViews;
        this.playerHolderImages = playerHolderImages;
        this.playerNameHolders = playerNameHolders;
        this.playerStatusBar = playerStatusBar;
        this.playerMoveNames = playerMoveNames;
        this.playerMoveRemains = playerMoveRemains;
        this.timerInfo = timerInfo;
        this.playerInfo = playerInfo;
        this.roundInfo = roundInfo;
        this.homeView = homeView;
        this.restartView = restartView;
        this.instructionView = instructionView;
        this.skipButton = skipButton;
        this.flipAgain = flipAgain;
        this.timer = timer;
        this.playerId = playerID;
        this.subscribers = new HashMap<>();
    }

    /**
     * This function will add the components that need to be updated in the UI
     *
     * @param subscriberType the type of subscriber
     * @param subscriber the subscriber
     */
    public void subscribe(SubscriberType subscriberType, Subscriber subscriber) {
        if (this.subscribers.containsKey(subscriberType)) {
            this.subscribers.get(subscriberType).add(subscriber);
        } else {
            ArrayList<Subscriber> subscriberArray = new ArrayList<>();
            subscriberArray.add(subscriber);
            this.subscribers.put(subscriberType, subscriberArray);
        }
    }

    /**
     * This function will remove all the component with a specific type of subscriber
     *
     * @param subscriberType the type of subscriber
     */
    public void unsubscribe(SubscriberType subscriberType) {
        this.subscribers.remove(subscriberType);
    }

    public void notifySubscriber(SubscriberType subscriberType, ImageView objectImageView, Image objectImage) {
        if (this.subscribers.containsKey(subscriberType)) {
            for (Subscriber subscriber: this.subscribers.get(subscriberType)) {
                subscriber.update(objectImageView, objectImage);
            }
        }
    }

    /**
     * This method will render the user interface for the game
     *
     * @param volcanoes A list of volcano that initialise in the game
     */
    public void initialRenderBoard(ArrayList<Volcano> volcanoes) {
        // initialise the game board
        Tile currentSquare = volcanoes.get(0).getSquares().get(0);
        for (ImageView squareAnimalImageView : squareAnimalImageViews) {
            squareAnimalImageView.setImage(new Image(GameController.class.getResource("/img/" + theme + "/" + currentSquare.getAnimal().getAnimalType() + ".png").toString()));

            currentSquare = currentSquare.getFrontTile();
        }

        // initialise the cave
        int caveCount = 0;
        for (Volcano volcano : volcanoes) {
            if (volcano.hasCave()) {
                this.caveAnimalImageViews[caveCount].setImage(new Image(GameController.class.getResource("/img/" + theme + "/" + volcano.getCave().getAnimal().getAnimalType() + ".png").toString()));

                caveCount++;
            }
        }
    }

    public void initialRenderPlayers(ArrayList<Player> players) {
        for (Player player : players) {
            int pos = player.getPlayerToken().getTile().getTileID();
            Image image = new Image(GameController.class.getResource("/img/" + theme + "/Player" + player.getPlayerID() + ".png").toString());

            if (pos >= 0) {
                this.squareTokenImageViews[pos].setImage(image);
            } else {
                this.caveTokenImageViews[abs(pos+1)].setImage(image);
            }
        }
    }

    public void initialRenderCards() {
        for (ImageView imageView : chitCardImageViews) {
            imageView.setImage(new Image(GameController.class.getResource("/img/" + theme + "/ChitCard.png").toString()));
        }
    }

    public void initialRenderElements() {
        playerStatusBar.setImage(new Image(GameController.class.getResource("/img/" + theme + "/PlayerStatus.png").toString()));
        timerInfo.setImage(new Image(GameController.class.getResource("/img/" + theme + "/TimerStat.png").toString()));
        playerInfo.setImage(new Image(GameController.class.getResource("/img/" + theme + "/PlayerStat.png").toString()));
        roundInfo.setImage(new Image(GameController.class.getResource("/img/" + theme + "/RoundStat.png").toString()));
        flipAgain.setImage(new Image(GameController.class.getResource("/img/" + theme + "/FlipAgain.png").toString()));
        homeView.setImage(new Image(GameController.class.getResource("/img/" + theme + "/HomeButton.png").toString()));
        restartView.setImage(new Image(GameController.class.getResource("/img/" + theme + "/RestartButton.png").toString()));
        instructionView.setImage(new Image(GameController.class.getResource("/img/" + theme + "/FAQButton.png").toString()));
    }

    /**
     * This method will render the player information for the game
     *
     * @param players A list of players to be initialised in the game
     */
    public void initialRenderPlayerInfo(ArrayList<Player> players) {
        for (Player player : players) {
            this.playerHolderImages[player.getPlayerID() - 1].setImage(new Image(GameController.class.getResource("/img/" + theme + "/Player" + player.getPlayerID() + ".png").toString()));
            this.playerNameHolders[player.getPlayerID() - 1].setText(player.getName());
        }
    }

    /**
     * This method will render the player move information for the game
     *
     * @param players A list of players to be initialised in the game
     */
    public void initialRenderPlayerMoveInfo(ArrayList<Player> players) {
        for (Player player : players) {
            this.playerMoveNames[player.getPlayerID() - 1].setText(player.getName());
            int moveRemaining = 26 - player.getPlayerToken().getTotalDisplacement();
            this.playerMoveRemains[player.getPlayerID() - 1].setText(String.valueOf(moveRemaining));
        }
    }

    /**
     * This method will update the player move information for the game
     *
     * @param player The player that will have info update
     */
    public void updatePlayerMoveInfo(Player player) {
        int moveRemaining = 26 - player.getPlayerToken().getTotalDisplacement();
        this.playerMoveRemains[player.getPlayerID() - 1].setText(String.valueOf(moveRemaining));
    }

    /**
     * This method will return the image view of a specific chit card
     *
     * @param index The index of the chit card to be return
     * @return The targeted chit card image view
     */
    public ImageView getChitCardImageView(int index) {
        return this.chitCardImageViews[index];
    }

    /**
     * This method will open a specific chit card
     *
     * @param chitCardImageView The chit card image view
     * @param chitCardImage The front of the chit card
     */
    public void openChitCard(ImageView chitCardImageView, Image chitCardImage) {
        this.notifySubscriber(SubscriberType.CHIT_CARD_SUBSCRIBER, chitCardImageView, chitCardImage);
    }

    /**
     * making the skip button visible
     *
     */
    public void setSkipButtonVisible(){
        flipAgain.setVisible(true);
        skipButton.setVisible(true);
    }

    /**
     * making the skip button invisible
     *
     */
    public void setSkipButtonInvisible(){
        flipAgain.setVisible(false);
        skipButton.setVisible(false);
    }

    /**
     * Updating the token position in the UI
     * @param turnManager The turn manager of the game
     * @param lastTile The current tile the token is on
     */
    public void moveToken(TurnManager turnManager, Tile lastTile) {
        ImageView squareTokenImageView;

        if (lastTile instanceof Square) {
            squareTokenImageView = this.squareTokenImageViews[lastTile.getTileID()];
        } else {
            squareTokenImageView = this.caveTokenImageViews[abs(lastTile.getTileID() + 1)];
        }

        this.notifySubscriber(SubscriberType.MOVEMENT_SUBSCRIBER, squareTokenImageView, null);

        if (turnManager.getCurrentPlayer().getPlayerToken().getTile() instanceof Square) {
            squareTokenImageView = this.squareTokenImageViews[turnManager.getCurrentPlayer().getPlayerToken().getTile().getTileID()];
        } else {
            squareTokenImageView = this.caveTokenImageViews[abs(turnManager.getCurrentPlayer().getPlayerToken().getTile().getTileID() + 1)];
        }
        Image tokenImage = new Image(getClass().getResourceAsStream(String.format("/img/%s/Player%d.png", theme, turnManager.getCurrentPlayer().getPlayerID())));

        this.notifySubscriber(SubscriberType.MOVEMENT_SUBSCRIBER, squareTokenImageView, tokenImage);
        this.updatePlayerMoveInfo(turnManager.getCurrentPlayer());
    }

    /**
     * Close the chit card
     * @param chitCardImage The image of the back of the chit card
     */
    public void closeChitCard(Image chitCardImage) {
        this.notifySubscriber(SubscriberType.CHIT_CARD_SUBSCRIBER, null, chitCardImage);
    }

    /**
     * Updating the current time left for the player turn
     * @param time the time left shown in the game
     */
    public void setTimer(String time) {
        this.timer.setText(time);
    }

    /**
     * Updating the current player in the UI
     * @param name the current player name
     */
    public void setPlayerName(String name) {
        this.playerId.setText(name);
    }
}
