package org.example.fierydragon;

/***
 * A class that represent DragonChitCardFactory
 * Created by: Jui Kai
 * @author Jui Kai
 */
public class DragonChitCardFactory implements ChitCardFactory {
    /**
     * Constructor
     *
     * @param moveStep
     * @return a new Dragon ChitCard
     */
    @Override
    public ChitCard createChitCard(int moveStep) {
        return new ChitCard(new Dragon(), moveStep);
    }
}
