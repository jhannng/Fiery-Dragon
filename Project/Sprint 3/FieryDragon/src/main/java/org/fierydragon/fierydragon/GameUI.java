package org.fierydragon.fierydragon;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.fierydragon.fierydragon.animal.AnimalType;
import org.fierydragon.fierydragon.controller.GameController;
import org.fierydragon.fierydragon.subscriber.Subscriber;
import org.fierydragon.fierydragon.subscriber.SubscriberType;
import org.fierydragon.fierydragon.tile.Square;
import org.fierydragon.fierydragon.tile.Tile;
import org.fierydragon.fierydragon.volcano.Volcano;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A class that used to initialise the user interface of the game
 * Created by:
 *  @author Teoh You Xian, Lim Jian Tao, Hang Jui Kai, Lee Yi Mei
 */
public class GameUI {
    private ImageView[] squareAnimalImageViews;
    private ImageView[] squareTokenImageViews;
    private ImageView[] chitCardImageViews;
    private ImageView[] caveAnimalImageViews;
    private ImageView[] caveTokenImageViews;
    private HashMap<SubscriberType, ArrayList<Subscriber>> subscribers;
    private Button skipButton;
    private ImageView flipAgain;
    private Label timer;
    private Label playerId;

    /**
     * Constructor
     *
     * @param squareAnimalImageViews A list of ImageView for the Square in the game
     * @param squareTokenImageViews A list of ImageView for the SquareToken in the game
     * @param chitCardImageViews A list of ImageView for the ChitCard in the game
     * @param caveAnimalImageViews A list of ImageView for the Animal of each Cave in the game
     * @param caveTokenImageViews A list of ImageView for the CaveToken in the game
     */
    public GameUI(ImageView[] squareAnimalImageViews, ImageView[] squareTokenImageViews, ImageView[] chitCardImageViews, ImageView[] caveAnimalImageViews, ImageView[] caveTokenImageViews, Button skipButton, ImageView flipAgain, Label timer, Label playerID) {
        this.squareAnimalImageViews = squareAnimalImageViews;
        this.squareTokenImageViews = squareTokenImageViews;
        this.chitCardImageViews = chitCardImageViews;
        this.caveAnimalImageViews = caveAnimalImageViews;
        this.caveTokenImageViews = caveTokenImageViews;
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
     * @param numOfPlayers The number of players in the game
     */
    public void initialRender(ArrayList<Volcano> volcanoes, int numOfPlayers) {
        // initialise the game board
        Tile currentSquare = volcanoes.get(0).getSquares().get(0);
        for (ImageView squareAnimalImageView : squareAnimalImageViews) {
            switch (currentSquare.getAnimal().getAnimalType()) {
                case BABY_DRAGON ->
                        squareAnimalImageView.setImage(new Image(GameController.class.getResource("/img/BabyDragon.png").toString()));
                case BAT ->
                        squareAnimalImageView.setImage(new Image(GameController.class.getResource("/img/Bat.png").toString()));
                case SALAMANDER ->
                        squareAnimalImageView.setImage(new Image(GameController.class.getResource("/img/Salamander.png").toString()));
                case SPIDER ->
                        squareAnimalImageView.setImage(new Image(GameController.class.getResource("/img/Spider.png").toString()));
            }

            currentSquare = currentSquare.getFrontTile();
        }

        // initialise the cave
        int caveCount = 0;
        int addedPlayer = 1;
        for (Volcano volcano : volcanoes) {
            if (volcano.hasCave()) {
                AnimalType animal = volcano.getCave().getAnimal().getAnimalType();
                switch (animal) {
                    case BABY_DRAGON -> this.caveAnimalImageViews[caveCount].setImage(new Image(GameController.class.getResource("/img/BabyDragon.png").toString()));
                    case BAT -> this.caveAnimalImageViews[caveCount].setImage(new Image(GameController.class.getResource("/img/Bat.png").toString()));
                    case SALAMANDER -> this.caveAnimalImageViews[caveCount].setImage(new Image(GameController.class.getResource("/img/Salamander.png").toString()));
                    case SPIDER -> this.caveAnimalImageViews[caveCount].setImage(new Image(GameController.class.getResource("/img/Spider.png").toString()));
                }
                // If 2 players, token should generate on the other side
                // If 3 or 4 players, generate the corresponding number of tokens
                if ((numOfPlayers == 2) && (caveCount % 2 == 0) || (numOfPlayers > 2 && caveCount < numOfPlayers)) {
                    this.caveTokenImageViews[caveCount].setImage(new Image(GameController.class.getResource("/img/Player" + (addedPlayer++) + ".png").toString()));
                }

                caveCount++;
            }
        }
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
            squareTokenImageView = this.caveTokenImageViews[lastTile.getTileID()];
        }

        this.notifySubscriber(SubscriberType.MOVEMENT_SUBSCRIBER, squareTokenImageView, null);

        if (turnManager.getCurrentPlayer().getPlayerToken().getTile() instanceof Square) {
            squareTokenImageView = this.squareTokenImageViews[turnManager.getCurrentPlayer().getPlayerToken().getTile().getTileID()];
        } else {
            squareTokenImageView = this.caveTokenImageViews[turnManager.getCurrentPlayer().getPlayerToken().getTile().getTileID()];
        }
        Image tokenImage = new Image(getClass().getResourceAsStream(String.format("/img/Player%d.png", turnManager.getCurrentPlayer().getPlayerID())));

        this.notifySubscriber(SubscriberType.MOVEMENT_SUBSCRIBER, squareTokenImageView, tokenImage);
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
     * @param id the current player id
     */
    public void setPlayerId(int id) {
        this.playerId.setText(String.valueOf(id));
    }
}
