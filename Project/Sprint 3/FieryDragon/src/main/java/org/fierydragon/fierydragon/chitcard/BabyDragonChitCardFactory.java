package org.fierydragon.fierydragon.chitcard;

import org.fierydragon.fierydragon.animal.BabyDragon;

/**
 * A factory class that create BabyDragon chit card in the game.
 * Created by:
 *  @author Teoh You Xian, Lim Jian Tao, Hang Jui Kai, Lee Yi Mei
 */
public class BabyDragonChitCardFactory implements ChitCardFactory {
    /**
     * Factory method that generate the BabyDragon chit card
     *
     * @param amount The amount of BabyDragon in the chit card
     * @return a BabyDragon chit card
     */
    @Override
    public ChitCard createChitCard(int amount) {
        return new ChitCard(new BabyDragon(), amount);
    }
}
