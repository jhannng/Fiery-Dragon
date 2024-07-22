package org.fierydragon.fierydragon.tile;

import org.fierydragon.fierydragon.Token;
import org.fierydragon.fierydragon.animal.Animal;

/**
 * An abstract class that represent the Tile in the game.
 * Created by:
 *  @author Lim Jian Tao
 */
public abstract class Tile {
    /**
     * The front tile of current tile
     */
    private Tile frontTile;
    /**
     * The back tile of current tile
     */
    private Tile backTile;
    /**
     * The token that is standing on the current tile
     */
    private Token token;
    /**
     * The animal of this square having
     */
    private Animal animal;
    private int tileID;

    /**
     * Constructor
     *
     * @param animal The animal of this tile
     */
    public Tile(Animal animal) {
        this.animal = animal;
    }

    /**
     * Setter method for front tile
     *
     * @param tile The new front linking tile of this tile
     */
    public void setFrontTile(Tile tile) {
        this.frontTile = tile;
    }

    /**
     * Setter method for back tile
     *
     * @param tile The new back linking tile of this tile
     */
    public void setBackTile(Tile tile) {
        this.backTile = tile;
    }

    /**
     * Getter method for front tile
     *
     * @return the front linking tile of this tile
     */
    public Tile getFrontTile() {
        return this.frontTile;
    }

    /**
     * Getter method for back tile
     *
     * @return the back linking tile of this tile
     */
    public Tile getBackTile() {
        return this.backTile;
    }

    /**
     * Getter method for animal
     *
     * @return the animal of the current tile
     */
    public Animal getAnimal() {
        return this.animal;
    }

    /**
     * This method will indicate whereas the tile is occupied
     *
     * @return true, if the token is not null, otherwise false
     */
    public boolean isOccupied() {
        return this.token != null;
    }

    /**
     * Getter method for token
     *
     * @return the token of the current tile
     */
    public Token getToken() {
        return this.token;
    }

    /**
     * Setter method for token
     *
     * @param token The new token of this tile
     */
    public void setToken(Token token) {
        this.token = token;
    }

    /**
     * getter for tile ID
     */
    public int getTileID() {
        return tileID;
    }

    /**
     * setter for the tile ID
     * @param tileID The new tile ID to be set
     */
    public void setTileID(int tileID) {
        this.tileID = tileID;
    }

    /**
     * This is an abstract method that move the Token forward to the next square. It will check if the total displacement of the token is equal to the total
     * required displacement before moving back into its cave. If yes, it will move back to the cave, otherwise it will move to the front cave.
     */
    public abstract void moveTokenForward();

    /**
     * This is an abstract method that move the Token backward to the previous square.
     */
    public abstract void moveTokenBackward(boolean enterCave);

    /**
     * This method will return the string that represent Tile
     * @return the string representation of this class
     */
    @Override
    public String toString() {
        return "Tile with " + animal.toString();
    }
}
