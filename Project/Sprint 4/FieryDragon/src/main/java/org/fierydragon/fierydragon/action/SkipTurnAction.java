package org.fierydragon.fierydragon.action;

import org.fierydragon.fierydragon.chitcard.ChitCard;
import org.fierydragon.fierydragon.Player;
import org.fierydragon.fierydragon.TurnManager;

/**
 * A class that represent the action of skipping turn in the game.
 * Created by:
 *  @author Teoh You Xian
 */
public class SkipTurnAction extends Action{
    /**
     * This method will execute on skipping turn to next Player
     *
     * @param player Current player in the game
     * @param chitCard Current selected chit card that being flipped
     * @return true
     */
    @Override
    public int execute(Player player, ChitCard chitCard){
        for (ChitCard flippedChitCard : TurnManager.getInstance().getFlippedChitCards()) {
            flippedChitCard.setFlipped(false);
        }

        TurnManager.getInstance().nextTurn();
        return 0;
    }
}