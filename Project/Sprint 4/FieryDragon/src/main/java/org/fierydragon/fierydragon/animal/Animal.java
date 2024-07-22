package org.fierydragon.fierydragon.animal;

/**
 * An abstract class that represents all the animals in the game.
 * Created by:
 *  @author Hang Jui Kai
 */
public abstract class Animal {
    /**
     * Name of the animal
     */
    private AnimalType animalType;

    /**
     * Visit both animals and return the number of moves
     *
     * @param animal The animal to be visited
     * @return the number of moves
     */
    abstract public int visit(Animal animal);

    /**
     * Getter method to return the name of Animal
     *
     * @return the name of the respective animal
     */
    public AnimalType getAnimalType() {
        return this.animalType;
    }

    /**
     * Setter method to set the name of Animal
     *
     * @param animalType The name of the animal
     */
    public void setAnimalType(AnimalType animalType) {
        this.animalType = animalType;
    }

    /**
     * This method will return the string that represent BabyDragon
     *
     * @return the string representation of this class
     */
    public String toString() {
        return this.getAnimalType().toString();
    }
}
