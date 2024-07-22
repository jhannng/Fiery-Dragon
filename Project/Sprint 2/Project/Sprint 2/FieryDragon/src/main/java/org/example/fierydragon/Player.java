package org.example.fierydragon;

/***
 * A class that represent Player
 * Created by: Jui Kai
 * @author Jui Kai
 */
public class Player {
    private final int playerID;
    private final String playerName;
    private final Token token;
    private boolean winStatus = false;

    /**
     * Constructor
     *
     * @param playerID
     * @param playerName
     */
    public Player(int playerID, String playerName) {
        this.playerID = playerID;
        this.playerName = playerName;
        this.token = new Token(playerID, playerID, 0);
    }

    /**
     * This method will update the state that indicate the player win the game
     */
    public void updateStatus() {
        this.winStatus = true;
    }

    /**
     * This method will return the player ID
     *
     * @return an integer that represent the player ID
     */
    public int getPlayerID() {
        return playerID;
    }

    /**
     * This method will return the Token
     *
     * @return the Token that belongs to this player
     */
    public Token getToken() {
        return token;
    }

    /**
     * This method will return the status of the playuer
     *
     * @return a boolean that represent the status pf player
     */
    public boolean getStatus() {
        return this.winStatus;
    }

    @Override
    public String toString() {
        return String.format("Player %s: %s", playerID, playerName);
    }
}
