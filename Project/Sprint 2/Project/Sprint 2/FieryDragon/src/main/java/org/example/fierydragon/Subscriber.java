package org.example.fierydragon;

/***
 * An interface for Subscriber
 * Created by: Jui Kai
 * @author Jui Kai
 */
public interface Subscriber {

    /**
     * This method will update the user interface once it's being invoke
     *
     * @param gameBoard
     * @param currentPlayer
     */
    void update(GameBoard gameBoard, Player currentPlayer);
}
