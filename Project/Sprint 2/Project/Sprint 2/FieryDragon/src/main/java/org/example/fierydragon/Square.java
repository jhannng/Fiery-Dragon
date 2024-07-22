package org.example.fierydragon;

/***
 * A class that represent Square
 * Created by: Jui Kai
 * @author Jui Kai
 */
public class Square {
    private final Animal animalType;
    private Token currentToken;
    private Square leftSquare;
    private Square rightSquare;
    private Cave cave;
    private boolean hasCave;

    /**
     * Constructor
     *
     * @param animalType
     * @param cave
     */
    public Square(Animal animalType, Cave cave) {
        this.animalType = animalType;
        this.cave = cave;
        this.setHasCave(cave);
    }

    /**
     * This method will set the boolean hasCave
     *
     * @param cave
     */
    private void setHasCave(Cave cave) {
        if (cave != null) {
            this.hasCave = true;
        } else {
            this.hasCave = false;
        }
    }

    /**
     * This method will add currentToken
     *
     * @param currentToken
     */
    public void addCurrentToken(Token currentToken) {
        this.currentToken = currentToken;
    }

    /**
     * This method will remove currentToken
     */
    public void removeCurrentToken() {
        this.currentToken = null;
    }

    /**
     * This method will return true if Squre consists of Cave
     *
     * @return true if Cave is not null
     */
    public boolean isHasCave() {
        return hasCave;
    }

    /**
     * This method will set the previous square
     *
     * @param leftSquare
     */
    public void setLeftSquare(Square leftSquare) {
        this.leftSquare = leftSquare;
    }

    /**
     * This method will set the next square
     *
     * @param rightSquare
     */
    public void setRightSquare(Square rightSquare) {
        this.rightSquare = rightSquare;
    }

    /**
     * This method will return the left square
     *
     * @return a Square that locate left of currentSquare
     */
    public Square getLeftSquare() {
        return leftSquare;
    }

    /**
     * This method will return the right square
     *
     * @return a Square that locate right of currentSquare
     */
    public Square getRightSquare() {
        return rightSquare;
    }

    /**
     * This method will return the animalType
     *
     * @return the animalType of Square
     */
    public Animal getAnimalType() {
        return animalType;
    }

    /**
     * This method will return currentToken locate at Square
     *
     * @return a Token that locate at current Square
     */
    public Token getToken() {
        return this.currentToken;
    }

    /**
     * This method will return the Cave
     *
     * @return the Cave that belongs to this Square
     */
    public Cave getCave() {
        return this.cave;
    }

    public String toString() {
        if (this.hasCave) {
            if (this.currentToken != null) {
                return String.format("Square Type: %s | Cave: %s | Left: %s | Right %s | %s | Token: %d", this.animalType, this.hasCave, this.leftSquare.animalType, this.rightSquare.animalType, this.cave.toString(), this.currentToken.getTokenID());
            } else {
                return String.format("Square Type: %s | Cave: %s | Left: %s | Right %s | %s", this.animalType, this.hasCave, this.leftSquare.animalType, this.rightSquare.animalType, this.cave.toString());
            }

        } else {
            if (this.currentToken != null) {
                return String.format("Square Type: %s | Cave: %s | Left: %s | Right %s | Token: %d", this.animalType, this.hasCave, this.leftSquare.animalType, this.rightSquare.animalType, this.currentToken.getTokenID());
            } else {
                return String.format("Square Type: %s | Cave: %s | Left: %s | Right %s", this.animalType, this.hasCave, this.leftSquare.animalType, this.rightSquare.animalType);
            }
        }
    }
}
