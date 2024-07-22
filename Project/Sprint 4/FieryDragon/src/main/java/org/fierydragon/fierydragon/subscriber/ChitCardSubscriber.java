package org.fierydragon.fierydragon.subscriber;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.ArrayList;

/**
 * A class that represent the ChitCardSubscriber in the game.
 * Created by:
 *  @author Teoh You Xian and Hang Jui Kai
 */
public class ChitCardSubscriber implements Subscriber {
    private ArrayList<ImageView> flippedChitCards;

    /**
     * Constructor
     */
    public ChitCardSubscriber() {
        this.flippedChitCards = new ArrayList<>();
    }

    /**
     * This method will update user interface of ChitCard
     * @param chitCardImageView The object of ChitCard's user interface
     * @param chitCardImage The image of the specific ChitCard
     */
    @Override
    public void update(ImageView chitCardImageView, Image chitCardImage) {
        if (chitCardImageView != null) {
            chitCardImageView.setImage(chitCardImage);
            this.flippedChitCards.add(chitCardImageView);
        } else {
            for (ImageView flippedChitCard: this.flippedChitCards) {
                flippedChitCard.setImage(chitCardImage);
            }
        }
    }
}
