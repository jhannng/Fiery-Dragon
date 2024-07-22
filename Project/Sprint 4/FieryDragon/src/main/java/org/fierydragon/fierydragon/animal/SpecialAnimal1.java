package org.fierydragon.fierydragon.animal;

/**
 * A class that represent first special Animal in the game
 * Created by:
 *  @author Hang Jui Kai
 */
public class SpecialAnimal1 extends Animal {
    /**
     * Constructor
     */
    public SpecialAnimal1() {
        this.setAnimalType(AnimalType.SPECIAL_ANIMAL1);
    }

    /**
     * Visit both animals and return the number of moves
     *
     * @param animal The animal to be visited
     * @return the number of moves
     */
    @Override
    public int visit(Animal animal) {
        return 2;
    }
}
