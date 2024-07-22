package org.fierydragon.fierydragon.chitcard;

import org.fierydragon.fierydragon.animal.BadAnimal1;

/**
 * A factory class that create first bad animal chit card in the game.
 * Created by:
 *  @author Lee Yi Mei
 */
public class BadAnimal1ChitCardFactory implements ChitCardFactory {
    /**
     * Factory method that generate the first bad animal chit card
     *
     * @param amount The amount of first bad animal in the chit card
     * @return first bad animal chit card
     */
    @Override
    public ChitCard createChitCard(int amount) {
        return new ChitCard(new BadAnimal1(), amount);
    }
}

