package org.example.fierydragon;

/***
 * A class that represent DragonPirateChitCardFactory
 * Created by: Jui Kai
 * @author Jui Kai
 */
public class DragonPirateChitCardFactory implements ChitCardFactory {
    /**
     * Constructor
     *
     * @param moveStep
     * @return a new DragonPirate ChitCard
     */
    @Override
    public ChitCard createChitCard(int moveStep) {
        return new ChitCard(new DragonPirate(), moveStep);
    }
}
