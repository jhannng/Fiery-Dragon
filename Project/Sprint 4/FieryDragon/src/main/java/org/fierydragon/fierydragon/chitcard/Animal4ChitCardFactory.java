package org.fierydragon.fierydragon.chitcard;

import org.fierydragon.fierydragon.animal.Animal4;

/**
 * A factory class that create fourth animal chit card in the game.
 * Created by:
 *  @author Lee Yi Mei
 */
public class Animal4ChitCardFactory implements ChitCardFactory{
    /***
     * Factory method that generate the fourth animal chit card
     *
     * @param amount The amount of fourth animal in the chit card
     * @return fourth animal chit card
     */
    @Override
    public ChitCard createChitCard(int amount) {
        return new ChitCard(new Animal4(), amount);
    }
}

