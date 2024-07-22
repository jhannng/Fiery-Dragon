package org.example.fierydragon;

/***
 * A class that represent BatSquareFactory
 * Created by: Jui Kai
 * @author Jui Kai
 */
public class BatSquareFactory implements SquareFactory {

    /**
     * Constructor
     *
     * @param cave
     * @return a new Bat Square
     */
    @Override
    public Square createSquare(Cave cave) {
        return new Square(new Bat(), cave);
    }
}
