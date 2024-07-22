package org.fierydragon.fierydragon.subscriber;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * An interface class that declares the notification interface for the game.
 * Created by:
 *  @author Teoh You Xian and Hang Jui Kai
 */
public interface Subscriber {
    /**
     * This method will update specific user interface
     *
     * @param objectImageView The object of specific user interface
     * @param objectImage The image of specific object
     */
    void update(ImageView objectImageView, Image objectImage);
}
