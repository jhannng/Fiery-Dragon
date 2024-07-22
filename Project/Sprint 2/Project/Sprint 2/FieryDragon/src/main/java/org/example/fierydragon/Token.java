package org.example.fierydragon;

/***
 * A class that represent Token
 * Created by: Jui Kai
 * @author Jui Kai
 */
public class Token {
    private final int tokenID;
    private final int playerID;
    private int tokenPosition;

    /**
     * Constructor
     *
     * @param tokenID
     * @param playerID
     * @param tokePosition
     */
    public Token(int tokenID, int playerID, int tokePosition) {
        this.tokenID = tokenID;
        this.playerID = playerID;
        this.tokenPosition = tokePosition;
    }

    /**
     * This methos will return the TokenID
     *
     * @return an integer that represent the tokenID
     */
    public int getTokenID() {
        return tokenID;
    }

    /**
     * This method will return playerID
     *
     * @return an interger that represent playerID
     */
    public int getPlayerID() {
        return playerID;
    }

    /**
     * This method will return the tokenPosition
     *
     * @return an interger that represent tokenPosition
     */
    public int getTokenPosition() {
        return tokenPosition;
    }

    /**
     * This method will increase the tokenPosition by one
     */
    public void increaseTokenPosition() {
        this.tokenPosition++ ;
    }

    /**
     * This method will decrease the tokePosition by one
     */
    public void decreaseTokenPosition() {
        this.tokenPosition-- ;
    }

    @Override
    public String toString() {
        return String.format("Token %s: \n Current Position: %s", tokenID, tokenPosition);
    }
}
