package org.fierydragon.fierydragon.chitcard;

import org.fierydragon.fierydragon.animal.Animal;

/***
 * A class that represent a chit card in the game.
 * Created by:
 *  @author Teoh You Xian, Lim Jian Tao, Hang Jui Kai, Lee Yi Mei
 */

public class ChitCard {
    /**
     * The animal type of this chit card
     */
    private Animal animal;
    /**
     * The amount of animal within this chit card
     */
    private int amountOfAnimal;
    /**
     * Flag of the chit card is flipped or not
     */
    private boolean flipped;

    /**
     * Constructor
     *
     * @param animal The animal type of this chit card
     * @param amountOfAnimal The amount of animal within this chit card
     */
    public ChitCard(Animal animal, int amountOfAnimal) {
        this.animal = animal;
        this.amountOfAnimal = amountOfAnimal;
        this.flipped = false;
    }

    /**
     * Setter method for setting the flag of ChitCard flip
     *
     * @param flipped A boolean to indicate whereas the ChitCard open or close
     */
    public void setFlipped(boolean flipped) {
        this.flipped = flipped;
    }

    /**
     * Getter method for the flag of the chit card us flipped or not
     *
     * @return the flag of the flipped state
     */
    public boolean getFlipped() {
        return this.flipped;
    }

    /**
     * Getter method for the animal of respective chit card
     *
     * @return the animal of the chit card
     */
    public Animal getAnimal() {
        return this.animal;
    }

    /**
     * Getter method for the amount of respective chit card
     *
     * @return the amount of animal within this chit card
     */
    public int getAmountOfAnimal() {
        return this.amountOfAnimal;
    }

    /**
     * This method will return the string that represent ChitCard
     *
     * @return the string representation of this class
     */
    @Override
    public String toString() {
        return "" + this.animal.toString() + " Chit card with amount " + this.amountOfAnimal;
    }
}

