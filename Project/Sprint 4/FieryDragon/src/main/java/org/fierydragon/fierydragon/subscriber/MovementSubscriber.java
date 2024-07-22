package org.fierydragon.fierydragon.subscriber;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * A class that represent the MovementSubscriber in the game.
 * Created by:
 *  @author Teoh You Xian and Hang Jui Kai
 */
public class MovementSubscriber implements Subscriber {
    /**
     * This method will update specific user interface
     *
     * @param objectImageView The object of specific user interface
     * @param objectImage The image of specific object
     */
    @Override
    public void update(ImageView objectImageView, Image objectImage) {
        objectImageView.setImage(objectImage);
    }
}
