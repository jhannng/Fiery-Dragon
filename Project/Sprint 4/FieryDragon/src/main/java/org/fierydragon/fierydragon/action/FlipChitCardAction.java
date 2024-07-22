package org.fierydragon.fierydragon.action;

import org.fierydragon.fierydragon.chitcard.ChitCard;
import org.fierydragon.fierydragon.Player;
import org.fierydragon.fierydragon.tile.Cave;
import org.fierydragon.fierydragon.tile.Square;
import org.fierydragon.fierydragon.tile.Tile;

import static java.lang.Math.abs;

/**
 * A class that represent the action of flipping chit card in the game.
 * Created by:
 *  @author Teoh You Xian
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
        int stats = chitCard.getAnimal().visit(player.getPlayerToken().getTile().getAnimal());
        int steps = stats * chitCard.getAmountOfAnimal();

        if (stats < 2) {
            boolean winningMove = player.getPlayerToken().getTotalDisplacement() + steps == 26;

            Tile targetTile = player.getPlayerToken().getTile();
            for (int i = 0; i < abs(steps); i++) {
                if (steps > 0) {
                    if (i + 1 == abs(steps) && winningMove) {
                        targetTile = ((Square)targetTile).getCave();
                    } else {
                        targetTile = targetTile.getFrontTile();
                    }
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
        } else {
            if (player.getPlayerToken().getTile() instanceof Cave) {
                return -1;
            }

            steps = 0;
            Tile currentSquare = player.getPlayerToken().getTile();

            while ( !((Square) currentSquare).hasCave() || ((Square) currentSquare).getCave().isOccupied() ) {
                currentSquare = currentSquare.getBackTile();
                steps--;
            }

            return --steps;
        }
        return steps;
    }
}