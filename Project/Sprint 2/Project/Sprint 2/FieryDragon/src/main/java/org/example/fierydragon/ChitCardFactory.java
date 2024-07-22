package org.example.fierydragon;

/***
 * An interface for ChitCardFactory
 * Created by: Jui Kai
 * @author Jui Kai
 */
public interface ChitCardFactory {
    /**
     * Constructor
     *
     * @param moveStep
     * @return a new ChitCard with identical AnimalType
     */
    ChitCard createChitCard(int moveStep);
}
