package org.fierydragon.fierydragon.volcano;
import org.fierydragon.fierydragon.tile.Cave;
import org.fierydragon.fierydragon.tile.Square;

import java.util.ArrayList;

/***
 * A class that represent Volcano in the game.
 * Created by:
 *  @author Teoh You Xian, Lim Jian Tao, Hang Jui Kai, Lee Yi Mei
 */
public class Volcano {
    /**
     * The array list of squares within the volcano
     */
    private ArrayList<Square> squares;
    /**
     * The cave within the volcano
     */
    private Cave cave;

    /**
     * Constructor
     */
    public Volcano() {
        this.squares = new ArrayList<>();
    }

    /**
     * Getter method for an array list of square
     *
     * @return the squares that is within the volcano card
     */
    public ArrayList<Square> getSquares() {
        return this.squares;
    }

    /**
     * Add a square into squares
     *
     * @param square The squares to be added
     */
    public void addSquare(Square square) {
        this.squares.add(square);
    }

    /**
     * Getter method for the size of volcano
     *
     * @return the length of squares that is within the volcano
     */
    public int getSquaresNumber() {
        return this.squares.size();
    }

    /**
     * Getter method for cave
     *
     * @return the cave that is within the volcano card
     */
    public Cave getCave() {
        return this.cave;
    }

    /**
     * Setter method for cave
     *
     * @param cave The cave to be set
     */
    public void setCave(Cave cave) {
        this.cave = cave;
    }

    /**
     * This method will check if current volcano has cave
     *
     * @return true if current volcano has cave, otherwise false
     */
    public boolean hasCave() {
        return this.cave != null;
    }

    /**
     * This method will return the string that represent Volcano
     *
     * @return the string representation of this class
     */
    @Override
    public String toString() {
        if (cave == null) {
            return "Volcano Card with Squares" + squares.toString() ;
        }
        else {
            return "Volcano Card with Squares" + squares.toString() + " and cave " + cave.toString();
        }
    }
}

