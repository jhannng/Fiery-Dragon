package org.fierydragon.fierydragon.volcano;

import org.fierydragon.fierydragon.tile.Cave;
import org.fierydragon.fierydragon.tile.Square;
import org.fierydragon.fierydragon.animal.Animal;

/**
 * A director class that represent the volcano in the game.
 * Created by:
 *  @author Lim Jian Tao
 */
public class VolcanoDirector {
    /**
     * This method will construct a volcano with squares
     *
     * @param builder The builder for building the volcano
     * @param animals All the animals required for building this cave
     * @return a new volcano instance
     */
    public Volcano constructVolcano(VolcanoBuilder builder, Animal... animals) {
        builder.resetBuilder();

        // add the square to the volcano
        for (Animal animal: animals) {
            builder.addSquare(animal);
        }

        return builder.buildVolcanoCard();
    }

    /**
     * This method will construct a volcano with a cave
     *
     * @param builder The builder for building a volcano
     * @param caveAnimal The animal of the cave
     * @param animals All the animals required for building this cave
     * @return a new volcano instance
     */
    public Volcano constructCaveVolcano(VolcanoBuilder builder, Animal caveAnimal, Animal... animals) {
        builder.resetBuilder();

        for (Animal animal: animals) {
            builder.addSquare(animal);
        }

        builder.setCave(caveAnimal);
        return builder.buildVolcanoCard();
    }
}
