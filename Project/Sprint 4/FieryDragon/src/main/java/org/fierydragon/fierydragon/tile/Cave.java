package org.fierydragon.fierydragon.tile;

import org.fierydragon.fierydragon.animal.Animal;

/***
 * A class that represent Cave in the game.
 * Created by:
 *  @author Lim Jian Tao
 */
public class Cave extends Tile {
    /**
     * Constructor
     *
     * @param animal The animal that this cave will have
     */
    public Cave(Animal animal) {
        super(animal);
    }

    /**
     * This method will move token out of the cave
     */
    @Override
    public void moveTokenForward() {
        super.getToken().displacementDone(1);

        // to get the next tile in volcano card
        super.getFrontTile().setToken(getToken());
        super.getToken().setTile(getFrontTile());
        super.setToken(null);
    }

    /**
     * Do nothing since cannot move backwards when in cave
     */
    @Override
    public void moveTokenBackward(boolean enterCave) {
    }

    /**
     * This method will return a string that represent the Cave.
     *
     * @return the string representation of this class
     */
    @Override
    public String toString() {
        return String.format("Cave %d with %s", this.getTileID(), this.getAnimal().toString());
    }
}