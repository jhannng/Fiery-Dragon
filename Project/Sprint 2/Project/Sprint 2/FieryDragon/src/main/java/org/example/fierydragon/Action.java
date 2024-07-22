package org.example.fierydragon;

/***
 * An abstract class that represent Action
 * Created by: Jui Kai
 * @author Jui Kai
 */
public abstract class Action {
    private Player currentPlayer;

    /**
     * Constructor
     *
     * @param currentPlayer
     */
    public Action(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    /**
     * This method return currentPlayer who performs action
     *
     * @return current player who performs action
     */
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * This method will execute the action
     *
     * @param gameBoard
     */
    abstract void executeAction(GameBoard gameBoard);
}
