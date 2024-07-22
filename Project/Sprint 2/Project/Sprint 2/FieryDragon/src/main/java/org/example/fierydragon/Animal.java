package org.example.fierydragon;

/***
 * An abstract class that represent Animal
 * Created by: Jui Kai
 * @author Jui Kai
 */
public abstract class Animal {
    private final AnimalType animal;

    /**
     * Constructor
     *
     * @param animal
     */
    public Animal(AnimalType animal) {
        this.animal = animal;
    }

    /**
     * This method return animal
     *
     * @return an animal type
     */
    public AnimalType getAnimal() {
        return animal;
    }
}
