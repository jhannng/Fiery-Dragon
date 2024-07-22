package org.fierydragon.fierydragon.chitcard;

/**
 * A factory interface that use by chit card in the game.
 * Created by:
 *  @author Teoh You Xian, Lim Jian Tao, Hang Jui Kai, Lee Yi Mei
 */
public interface ChitCardFactory {
    /**
     * Factory method that generate the respective chit card
     *
     * @param amount The amount of BabyDragon in the chit card
     * @return the respective chit card
     */
    ChitCard createChitCard(int amount);
}
