package org.fierydragon.fierydragon.animal;

/**
 * A class that represent first bad Animal in the game
 * Created by:
 *  @author Hang Jui Kai
 */
public class BadAnimal1 extends Animal{
    /**
     * Constructor
     */
    public BadAnimal1() {
        this.setAnimalType(AnimalType.BAD_ANIMAL1);
    }

    /**
     * Visit both animals and return the number of moves
     *
     * @param animal The animal to be visited
     * @return the number of moves
     */
    @Override
    public int visit(Animal animal) {
        return -1;
    }
}