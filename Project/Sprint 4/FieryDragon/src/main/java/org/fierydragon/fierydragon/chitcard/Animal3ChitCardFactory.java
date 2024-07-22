package org.fierydragon.fierydragon.chitcard;

import org.fierydragon.fierydragon.animal.Animal3;

/**
 * A factory class that represent third animal chit card in the game.
 * Created by:
 *  @author Lee Yi Mei
 */
public class Animal3ChitCardFactory implements ChitCardFactory {
    /**
     * Factory method that generate the third animal chit card
     *
     * @param amount The amount of third animal in the chit card
     * @return third animal chit card
     */
    @Override
    public ChitCard createChitCard(int amount) {
        return new ChitCard(new Animal3(), amount);
    }
}

