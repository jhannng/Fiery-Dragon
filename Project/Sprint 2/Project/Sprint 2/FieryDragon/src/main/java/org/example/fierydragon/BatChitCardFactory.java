package org.example.fierydragon;

/***
 * A class that represent BatChitCardFactory
 * Created by: Jui Kai
 * @author Jui Kai
 */
public class BatChitCardFactory implements ChitCardFactory {

    /**
     * Constructor
     *
     * @param moveStep
     *
     * @return a new Bat ChitCard
     */
    @Override
    public ChitCard createChitCard(int moveStep) {
        return new ChitCard(new Bat(), moveStep);
    }
}
