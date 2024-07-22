package org.fierydragon.fierydragon.chitcard;

import org.fierydragon.fierydragon.animal.Salamander;

/**
 * A factory class that represent Salamander chit card in the game.
 * Created by:
 *  @author Teoh You Xian, Lim Jian Tao, Hang Jui Kai, Lee Yi Mei
 */

public class SalamanderChitCardFactory implements ChitCardFactory {
    /**
     * Factory method that generate the Salamander chit card
     *
     * @param amount The amount of Salamander in the chit card
     * @return a Salamander chit card
     */
    @Override
    public ChitCard createChitCard(int amount) {
        return new ChitCard(new Salamander(), amount);
    }
}

