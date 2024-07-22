package org.example.fierydragon;

/***
 * An interface for SquareFactory
 * Created by: Jui Kai
 * @author Jui Kai
 */
public interface SquareFactory {
    /**
     * Constructor
     *
     * @param cave
     * @return a new Square
     */
    Square createSquare(Cave cave);
}
