package org.fierydragon.fierydragon.volcano;

import org.fierydragon.fierydragon.animal.Animal;
import org.fierydragon.fierydragon.tile.Cave;
import org.fierydragon.fierydragon.tile.Square;

/**
 * A builder class that represent the volcano in the game.
 * Created by:
 *  @author Lim Jian Tao
 */
public class VolcanoBuilder {
    /**
     * The squares that will be in the volcano
     */
    private Volcano volcano;

    /**
     * This method will add the square into the builder
     *
     * @param animal The animal of the square to be added
     */
    public void addSquare(Animal animal) {
        this.volcano.addSquare(new Square(animal));
    }

    /**
     * This method will add the cave into the builder
     *
     * @param animal The animal of the cave to be added
     */
    public void setCave(Animal animal) {
        this.volcano.setCave(new Cave(animal));
    }

    /**
     * This method will build the volcano card
     *
     * @return the volcano card object
     */
    public Volcano buildVolcanoCard() {
        return this.volcano;
    }

    /**
     * This method will reset the state of builder for next build
     */
    public void resetBuilder() {
        this.volcano = new Volcano();
    }
}

