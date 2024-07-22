package org.fierydragon.fierydragon.animal;

/**
 * A class that represent Salamander in the game.
 * Created by:
 *  @author Teoh You Xian, Lim Jian Tao, Hang Jui Kai, Lee Yi Mei
 */
public class Salamander extends Animal{
    /**
     * Constructor
     */
    public Salamander() {
        this.setAnimalType(AnimalType.SALAMANDER);
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