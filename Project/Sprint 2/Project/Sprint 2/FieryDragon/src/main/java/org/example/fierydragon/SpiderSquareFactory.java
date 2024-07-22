package org.example.fierydragon;

/***
 * A class that represent SpiderSquareFactory
 * Created by: Jui Kai
 * @author Jui Kai
 */
public class SpiderSquareFactory implements SquareFactory{
    /**
     * Constructor
     *
     * @param cave
     * @return a new Spider Square
     */
    @Override
    public Square createSquare(Cave cave) {
        return new Square(new Spider(), cave);
    }
}
