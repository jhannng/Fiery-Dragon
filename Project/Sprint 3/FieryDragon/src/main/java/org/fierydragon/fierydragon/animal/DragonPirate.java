package org.fierydragon.fierydragon.animal;

/**
 * A class that represent DragonPirate in the game
 * Created by:
 *  @author Teoh You Xian, Lim Jian Tao, Hang Jui Kai, Lee Yi Mei
 */
public class DragonPirate extends Animal{
    /**
     * Constructor
     */
    public DragonPirate() {
        this.setAnimalType(AnimalType.DRAGON_PIRATE);
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