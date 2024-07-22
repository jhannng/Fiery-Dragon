package org.fierydragon.fierydragon.chitcard;

import org.fierydragon.fierydragon.animal.Animal1;

/**
 * A factory class that create first animal chit card in the game.
 * Created by:
 *  @author Lee Yi Mei
 */
public class Animal1ChitCardFactory implements ChitCardFactory {
    /**
     * Factory method that generate the first animal chit card
     *
     * @param amount The amount of first animal in the chit card
     * @return first animal chit card
     */
    @Override
    public ChitCard createChitCard(int amount) {
        return new ChitCard(new Animal1(), amount);
    }
}
