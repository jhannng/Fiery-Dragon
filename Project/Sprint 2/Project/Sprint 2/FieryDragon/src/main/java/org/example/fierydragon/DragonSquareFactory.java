package org.example.fierydragon;

/***
 * A class that represent DragonSquareFactory
 * Created by: Jui Kai
 * @author Jui Kai
 */
public class DragonSquareFactory implements SquareFactory {
    /**
     * Constructor
     *
     * @param cave
     * @return a new Dragon Square
     */
    @Override
    public Square createSquare(Cave cave) {
        return new Square(new Dragon(), cave);
    }
}
