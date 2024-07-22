package org.example.fierydragon;

/***
 * A class that represent SpiderChitCardFactory
 * Created by: Jui Kai
 * @author Jui Kai
 */
public class SpiderChitCardFactory implements ChitCardFactory {
    /**
     * Constructor
     *
     * @param moveStep
     * @return a new Spider ChitCard
     */
    @Override
    public ChitCard createChitCard(int moveStep) {
        return new ChitCard(new Spider(), moveStep);
    }
}
