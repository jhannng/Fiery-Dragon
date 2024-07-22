package org.example.fierydragon;

/***
 * A class that represent SalamanderChitCardFactory
 * Created by: Jui Kai
 * @author Jui Kai
 */
public class SalamanderChitCardFactory implements ChitCardFactory {
    /**
     * Constructor
     *
     * @param moveStep
     * @return a new Salamander ChitCard
     */
    @Override
    public ChitCard createChitCard(int moveStep) {
        return new ChitCard(new Salamander(), moveStep);
    }
}
