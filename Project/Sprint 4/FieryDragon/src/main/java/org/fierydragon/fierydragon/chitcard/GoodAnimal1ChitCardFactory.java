package org.fierydragon.fierydragon.chitcard;

import org.fierydragon.fierydragon.animal.GoodAnimal1;

/**
 * A factory class that create first good animal chit card in the game.
 * Created by:
 *  @author Lee Yi Mei
 */
public class GoodAnimal1ChitCardFactory implements ChitCardFactory {
    /**
     * Factory method that generate the first good animal chit card
     *
     * @param amount The amount of first good animal in the chit card
     * @return first good animal chit card
     */
    @Override
    public ChitCard createChitCard(int amount) {
        return new ChitCard(new GoodAnimal1(), amount);
    }
}
