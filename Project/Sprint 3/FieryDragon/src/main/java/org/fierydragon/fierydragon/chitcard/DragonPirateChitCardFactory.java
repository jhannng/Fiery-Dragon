package org.fierydragon.fierydragon.chitcard;

import org.fierydragon.fierydragon.animal.DragonPirate;

/**
 * A factory class that create DragonPirate chit card in the game.
 * Created by:
 *  @author Teoh You Xian, Lim Jian Tao, Hang Jui Kai, Lee Yi Mei
 */
public class DragonPirateChitCardFactory implements ChitCardFactory {
    /**
     * Factory method that generate the DragonPirate chit card
     *
     * @param amount The amount of DragonPirate in the chit card
     * @return a DragonPirate chit card
     */
    @Override
    public ChitCard createChitCard(int amount) {
        return new ChitCard(new DragonPirate(), amount);
    }
}

