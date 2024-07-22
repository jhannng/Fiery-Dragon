package org.fierydragon.fierydragon.animal;

/**
 * A class that represent fourth Animal in the game.
 * Created by:
 *  @author Hang Jui Kai
 */
public class Animal4 extends Animal{
    /**
     * Constructor
     */
    public Animal4() {
        this.setAnimalType(AnimalType.ANIMAL4);
    }

    /**
     * Visit both animals and return the number of moves
     *
     * @param animal The animal to be visited
     * @return the number of moves
     */
    @Override
    public int visit(Animal animal) {
        return animal.getAnimalType() == this.getAnimalType() ? 1 : 0;
    }
}
