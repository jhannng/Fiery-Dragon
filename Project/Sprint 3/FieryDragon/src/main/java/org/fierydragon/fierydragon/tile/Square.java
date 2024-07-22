package org.fierydragon.fierydragon.tile;

import org.fierydragon.fierydragon.animal.Animal;

/***
 * A class that represent Square in the game.
 * Created by:
 *  @author Teoh You Xian, Lim Jian Tao, Hang Jui Kai, Lee Yi Mei
 */
public class Square extends Tile {
    /**
     * The linking cave of this square
     */
    private Cave cave;

    /**
     * Constructor
     *
     * @param animal The animal of this square
     */
    public Square(Animal animal) {
        super(animal);
    }

    /**
     * Setter method for Cave
     *
     * @param cave The cave that will be linked with this current square
     */
    public void setCave(Cave cave) {
        this.cave = cave;
    }

    /**
     * Getter method for Cave
     *
     * @return the linked cave of this square
     */
    public Cave getCave() {
        return this.cave;
    }

    /**
     * This method is an action that move the Token forward to the next square. It will check if the total displacement of the token is equal to the total
     * required displacement before moving back into its cave. If yes, it will move back to the cave, otherwise it will move to the front cave.
     */
    @Override
    public void moveTokenForward() {
        super.getToken().displacementDone(1);
        if (super.getToken().getTotalDisplacement() == 26){
            // move token to cave
            this.getCave().setToken(getToken());
            super.setToken(null);
        }
        else {
            // move token to next square
            super.getFrontTile().setToken(getToken());
            super.getToken().setTile(getFrontTile());
            super.setToken(null);
        }
    }

    /**
     * This method is an action that move the Token backward to the previous square.
     */
    @Override
    public void moveTokenBackward() {
        super.getToken().displacementDone(-1);

        // move token to previous square
        super.getBackTile().setToken(getToken());
        super.getToken().setTile(getBackTile());
        super.setToken(null);
    }

    /**
     * This method will return the string that represent Square
     *
     * @return the string representation of this class
     */
    @Override
    public String toString() {
        if (cave != null) {
            return String.format("Square %d with %s which links to %s", this.getTileID(), this.getAnimal().toString(), this.cave.toString());
        }
        else {
            return String.format("Square %d with %s", this.getTileID(), this.getAnimal().toString());
        }
    }
}
