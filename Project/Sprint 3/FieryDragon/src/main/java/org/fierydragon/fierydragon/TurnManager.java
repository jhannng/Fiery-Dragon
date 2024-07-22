package org.fierydragon.fierydragon;

import org.fierydragon.fierydragon.chitcard.ChitCard;

import java.util.ArrayList;

/**
 * A class that handle the turn in the game.
 * Created by:
 *  @author Teoh You Xian, Lim Jian Tao, Hang Jui Kai, Lee Yi Mei
 */
public class TurnManager {
    /**
     * An instance variable of TurnManager
     */
    private static TurnManager instance;
    /**
     * To indicate the turn of player in the game
     */
    private int turn;
    /**
     * The list of players in the game
     */
    private ArrayList<Player> players;
    /**
     * The list of chit cards in the game
     */
    private ArrayList<ChitCard> flippedChitCards;

    /**
     * Constructor
     */
    private TurnManager() {
        this.turn = 1;
        this.flippedChitCards = new ArrayList<>();
    }

    /**
     * This method will return the instance of TurnManager
     *
     * @return the TurnManager instance
     */
    public static TurnManager getInstance() {
        if (instance == null) {
            instance = new TurnManager();
        }

        return instance;
    }

    /**
     * This method will set the number of player for the game
     * @param players All the players in the game
     */
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    /**
     * This method will return the turn of the game
     *
     * @return the turn in the game
     */
    public int getTurn() {
        return this.turn;
    }

    /**
     * This method will change the turn
     */
    public void nextTurn() {
        this.flippedChitCards.clear();
        this.turn = (this.turn % this.players.size()) + 1;
    }

    /**
     * This method will return current player
     *
     * @return the current player in the game
     */
    public Player getCurrentPlayer() {
        return this.players.get(this.turn - 1);
    }

    /**
     * This method will return all the players in the game
     *
     * @return All the player in the game
     */
    public ArrayList<Player> getAllPlayers() {
        return this.players;
    }

    /**
     * This method will add the chit card once the chit card being flipped
     *
     * @param chitCard Current flipped chit card
     */
    public void addFlippedChitCard(ChitCard chitCard) {
        this.flippedChitCards.add(chitCard);
    }

    /**
     * This method will return a list of flipped chit card
     *
     * @return the list of flipped chit card
     */
    public ArrayList<ChitCard> getFlippedChitCards() {
        return this.flippedChitCards;
    }

    /**
     * Used to reset the turn to the first player whenever a new game starts
     *
     */
    public void reset(){
        this.turn = 1;
    }
}
