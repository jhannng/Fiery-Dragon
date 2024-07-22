package org.example.fierydragon;

/***
 * A class that represent VolcanoCard
 * Created by: Jui Kai
 * @author Jui Kai
 */
import java.util.ArrayList;

public class VolcanoCard {
    private ArrayList<Square> volcanoCard = new ArrayList<>();

    /**
     * Constructor
     *
     * @param square
     * @param cave
     */
    public VolcanoCard(SquareFactory[] square, Cave cave) {
        this.initialiseSquare(square, cave);
    }

    /**
     * This method will initialise the Square
     *
     * @param square
     * @param cave
     */
    private void initialiseSquare(SquareFactory[] square, Cave cave) {
        for (int idx = 0; idx < square.length; idx ++) {
            if (idx == 1) {
                Square newSquare = square[idx].createSquare(cave);
                volcanoCard.add(newSquare);
            } else {
                Square newSquare = square[idx].createSquare(null);
                volcanoCard.add(newSquare);
            }
        }
    }

    /**
     * This method will return a list oif Square
     *
     * @return a list of Sqaure
     */
    public ArrayList<Square> getVolcanoCard() {
        return volcanoCard;
    }

    public String toString() {
        String result = "";

        for (int idx = 0; idx < volcanoCard.size(); idx ++) {
            result += String.format("%s\n", volcanoCard.get(idx).toString());
        }

        return result;
    }
}
