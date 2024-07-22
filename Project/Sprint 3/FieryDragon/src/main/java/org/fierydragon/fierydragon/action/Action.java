package org.fierydragon.fierydragon.action;

import org.fierydragon.fierydragon.chitcard.ChitCard;
import org.fierydragon.fierydragon.Player;

/**
 * An abstract class that represents all actions in FieryDragon game.
 * Created by:
 *  @author Teoh You Xian, Lim Jian Tao, Hang Jui Kai, Lee Yi Mei
 */
public abstract class Action{
    /**
     * To execute the action
     * @param player Current player in the game
     * @param chitCard Current selected ChitCard that being flipped
     * @return the steps that token requires to move
     */
    public abstract int execute(Player player, ChitCard chitCard);
}