package org.fierydragon.fierydragon.chitcard;

import org.fierydragon.fierydragon.animal.Animal2;

/**
 * A factory class that create second animal chit card in the game.
 * Created by:
 *  @author Lee Yi Mei
 */
public class Animal2ChitCardFactory implements ChitCardFactory{
    /**
     * Factory method that generate the second animal chit card
     *
     * @param amount The amount of second animal in the chit card
     * @return second animal chit card
     */
    @Override
    public ChitCard createChitCard(int amount) {
        return new ChitCard(new Animal2(), amount);
    }
}
