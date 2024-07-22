package org.fierydragon.fierydragon.subscriber;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MovementSubscriber implements Subscriber {

    @Override
    public void update(ImageView objectImageView, Image objectImage) {
        objectImageView.setImage(objectImage);
    }
}
