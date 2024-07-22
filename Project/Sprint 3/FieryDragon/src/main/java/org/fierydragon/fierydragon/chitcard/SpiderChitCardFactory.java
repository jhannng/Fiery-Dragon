package org.fierydragon.fierydragon.chitcard;

import org.fierydragon.fierydragon.animal.Spider;

/**
 * A factory class that create Spider chit card in the game.
 * Created by:
 *  @author Teoh You Xian, Lim Jian Tao, Hang Jui Kai, Lee Yi Mei
 */
public class SpiderChitCardFactory implements ChitCardFactory{
    /***
     * Factory method that generate the Spider chit card
     *
     * @param amount The amount of Spider in the chit card
     * @return a Spider chit card
     */
    @Override
    public ChitCard createChitCard(int amount) {
        return new ChitCard(new Spider(), amount);
    }
}

