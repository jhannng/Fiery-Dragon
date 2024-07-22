package org.fierydragon.fierydragon.animal;

/**
 * A class that represent first good Animal in the game
 * Created by:
 *  @author Hang Jui Kai
 */
public class GoodAnimal1 extends Animal {
    /**
     * Constructor
     */
    public GoodAnimal1() {
        this.setAnimalType(AnimalType.GOOD_ANIMAL1);
    }

    /**
     * Visit both animals and return the number of moves
     *
     * @param animal The animal to be visited
     * @return the number of moves
     */
    @Override
    public int visit(Animal animal) {
        return 1;
    }
}
