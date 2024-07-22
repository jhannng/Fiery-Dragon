package org.fierydragon.fierydragon.action;

import org.fierydragon.fierydragon.chitcard.ChitCard;
import org.fierydragon.fierydragon.Player;
import org.fierydragon.fierydragon.tile.Tile;

import static java.lang.Math.abs;

/**
 * A class that represent the action of flipping chit card in the game.
 * Created by:
 *  @author Teoh You Xian, Lim Jian Tao, Hang Jui Kai, Lee Yi Mei
 */
public class FlipChitCardAction extends Action{
    /**
     * This method will execute on flipping the ChitCard
     *
     * @param player Current player in the game
     * @param chitCard Current selected ChitCard that being flipped
     * @return the steps that token requires to move
     */
    @Override
    public int execute(Player player, ChitCard chitCard) {
        chitCard.setFlipped(true);
        int steps = chitCard.getAnimal().visit(player.getPlayerToken().getTile().getAnimal()) * chitCard.getAmountOfAnimal();

        Tile targetTile = player.getPlayerToken().getTile();
        for (int i = 0; i < abs(steps); i++) {
            if (steps > 0) {
            targetTile = targetTile.getFrontTile();
            }
            else {
                if (targetTile != null) {
                    targetTile = targetTile.getBackTile();
                }
            }

        }

        if (targetTile != null && targetTile.isOccupied()) {
            return 0;
        }

        return steps;
    }
}