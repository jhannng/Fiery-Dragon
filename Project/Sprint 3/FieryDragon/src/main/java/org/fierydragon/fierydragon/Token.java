package org.fierydragon.fierydragon;

import org.fierydragon.fierydragon.tile.Tile;

/***
 * A class that represents Token in the game.
 * Created by:
 *  @author Teoh You Xian, Lim Jian Tao, Hang Jui Kai, Lee Yi Mei
 */
public class Token {
    /**
     * It will store the square that the token is currently on
     */
    private Tile tile;
    /**
     * The player identifier of the token
     */
    private int playerID;
    /**
     * Total displacement of the token
     */
    private int totalDisplacement;
    /**
     * The last total displacement of the token
     */
    private int lastTotalDisplacement;

    /**
     * Constructor
     *
     * @param playerID The player id for respective token
     */
    public Token(int playerID) {
        this.playerID = playerID;
    }

    /**
     * This method will indicate the displacement moved by the token
     *
     * @param displacement the displacement occurred
     */
    public void displacementDone(int displacement) {
        // this condition is used to ensure that the token doesn't move exceed
        if (this.totalDisplacement + displacement < 27) {
            this.lastTotalDisplacement = this.totalDisplacement;

            this.totalDisplacement += displacement;
        }
    }

    /**
     * Getter method for the total displacement
     *
     * @return the total displacement for the token
     */
    public int getTotalDisplacement() {
        return this.totalDisplacement;
    }

    /**
     * Setter method for the tile
     *
     * @param tile The tile that the token will be located at
     */
    public void setTile(Tile tile) {
        this.tile = tile;
    }

    /**
     * Getter method for the tile
     *
     * @return the square that the token locate at
     */
    public Tile getTile() {
        return tile;
    }
}

