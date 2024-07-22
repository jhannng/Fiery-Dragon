package org.fierydragon.fierydragon.chitcard;

import org.fierydragon.fierydragon.animal.SpecialAnimal1;

/**
 * A factory class that create first special animal chit card in the game.
 * Created by:
 *  @author Lee Yi Mei
 */
public class SpecialAnimal1ChitCardFactory implements ChitCardFactory {
    /**
     * Factory method that generate the first special animal chit card
     *
     * @param amount The amount of first special animal in the chit card
     * @return first special animal chit card
     */
    @Override
    public ChitCard createChitCard(int amount) {
        return new ChitCard(new SpecialAnimal1(), amount);
    }
}
