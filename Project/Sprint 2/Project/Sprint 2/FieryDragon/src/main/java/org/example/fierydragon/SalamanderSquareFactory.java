package org.example.fierydragon;

/***
 * A class that represent SalamanderSquareFactory
 * Created by: Jui Kai
 * @author Jui Kai
 */
public class SalamanderSquareFactory implements SquareFactory {
    /**
     * Constructor
     *
     * @param cave
     * @return a new Salamander Square
     */
    @Override
    public Square createSquare(Cave cave) {
        return new Square(new Salamander(), cave);
    }
}
