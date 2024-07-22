package org.fierydragon.fierydragon;

/**
 * A class that represent the Player in the game.
 * Created by:
 *  @author Teoh You Xian, Lim Jian Tao, Hang Jui Kai, Lee Yi Mei
 */
public class Player {
    /**
     * The identifier of the player
     */
    private final int playerID;
    /**
     * The name of the player
     */
    private String name;
    /**
     * The token of respective player
     */
    private final Token playerToken;

    /**
     * Constructor
     *
     * @param name The name of the player
     * @param playerID The identifier of the player
     */
    public Player(String name, int playerID) {
        this.name = name;
        this.playerID = playerID;
        this.playerToken = new Token(playerID);
    }

    /**
     * Getter method for the player's name
     *
     * @return the name of player
     */
    public String getName() {
        return name;
    }

    /**
     * Getter method for player's identifier
     *
     * @return the identifier of the player
     */
    public int getPlayerID() {
        return playerID;
    }

    /**
     * Getter method for player's token
     *
     * @return the token of the player
     */
    public Token getPlayerToken() {
        return playerToken;
    }

    /**
     * This method return the string that represent the Player in the game
     *
     * @return the string representation of this class
     */
    @Override
    public String toString() {
        return this.name;
    }
}


