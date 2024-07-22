package org.example.fierydragon;

/***
 * A class that represent Cave
 * Created by: Jui Kai
 * @author Jui Kai
 */
public class Cave {
    private final int caveID;
    private Token caveToken;
    private final Animal animalType;
    private Square exitSquare;

    /**
     * Constructor
     *
     * @param animalType
     * @param caveID
     */
    public Cave(Animal animalType, int caveID) {
        this.animalType = animalType;
        this.caveID = caveID;
    }

    /**
     * This method set the exitSquare
     *
     * @param exitSquare
     */
    public void setExitSquare(Square exitSquare) {
        this.exitSquare = exitSquare;
    }

    /**
     * This method add caveToken
     *
     * @param caveToken
     */
    public void addCaveToken(Token caveToken) {
        this.caveToken = caveToken;
    }

    /**
     * This method remove the caveToken
     */
    public void removeCaveToken() {
        this.caveToken = null;
    }

    /**
     * This method return CaveID
     *
     * @return an integer that represent the CaveID
     */
    public int getCaveID() {
        return caveID;
    }

    /**
     * This method return Token
     *
     * @return the caveToken
     */
    public Token getToken() {
        return this.caveToken;
    }

    /**
     * This method return AnimalType
     *
     * @return the animalType of the Cave
     */
    public Animal getAnimalType() {
        return animalType;
    }

    /**
     * This method return exitSquare
     *
     * @return the exitSquare of the Cave
     */
    public Square getExitSquare() {
        return this.exitSquare;
    }

    public String toString() {
        if (this.exitSquare != null) {
            if (this.caveToken != null) {
                return String.format("Cave Type: %s {Exit Square: %s | Cave ID: Cave %d} | Token %d", this.animalType, this.exitSquare.getAnimalType(), this.caveID, this.caveToken.getTokenID());
            } else {
                return String.format("Cave Type: %s {Exit Square: %s | Cave ID: Cave %d} ", this.animalType, this.exitSquare.getAnimalType(), this.caveID);
            }
        } else {
            return String.format("Cave Type: %s", this.animalType);
        }
    }
}
