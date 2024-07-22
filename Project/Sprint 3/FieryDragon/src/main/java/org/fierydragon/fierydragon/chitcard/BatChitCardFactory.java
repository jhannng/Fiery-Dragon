package org.fierydragon.fierydragon.chitcard;

import org.fierydragon.fierydragon.animal.Bat;

/**
 * A factory class that create Bat chit card in the game.
 * Created by:
 *  @author Teoh You Xian, Lim Jian Tao, Hang Jui Kai, Lee Yi Mei
 */
public class BatChitCardFactory implements ChitCardFactory{
    /**
     * Factory method that generate the Bat chit card
     *
     * @param amount The amount of Bat in the chit card
     * @return a Bat chit card
     */
    @Override
    public ChitCard createChitCard(int amount) {
        return new ChitCard(new Bat(), amount);
    }
}
