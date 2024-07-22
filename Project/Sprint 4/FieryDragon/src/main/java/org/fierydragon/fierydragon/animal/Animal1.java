package org.fierydragon.fierydragon.animal;

/**
 * A class that represent first Animal in the game.
 * Created by:
 *  @author Hang Jui Kai
 */
public class Animal1 extends Animal{
    /**
     * Constructor
     */
    public Animal1() {
        this.setAnimalType(AnimalType.ANIMAL1);
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