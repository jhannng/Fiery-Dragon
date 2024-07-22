package org.example.fierydragon;

/***
 * A class that represent ChitCard
 * Created by: Jui Kai
 * @author Jui Kai
 */
public class ChitCard {
    private final Animal animalType;
    private final int moveStep;

    /**
     * Constructor
     *
     * @param animalType
     * @param moveStep
     */
    public ChitCard(Animal animalType, int moveStep) {
        this.animalType = animalType;
        this.moveStep = moveStep;
    }

    /**
     * This method return animalType
     *
     * @return the animalTyoe of ChitCard
     */
    public Animal getAnimalType() {
        return animalType;
    }

    /**
     * This method return the moveStep
     *
     * @return an integer that represent the moveStep
     */
    public int getMoveStep() {
        return moveStep;
    }

    public String toString() {
        return String.format("{Animal Type: %s | Step: %s} ", this.animalType, this.moveStep);
    }
}
